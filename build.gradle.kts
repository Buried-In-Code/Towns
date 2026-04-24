import com.diffplug.spotless.kotlin.KtfmtStep.TrailingCommaManagementStrategy
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.github.benmanes.gradle.versions.updates.resolutionstrategy.ComponentSelectionWithCurrent

plugins {
  alias(libs.plugins.shadow)
  alias(libs.plugins.spotless)
  alias(libs.plugins.versions)
  application
}

group = "xaos"

version = "0.15.0"

repositories {
  mavenLocal()
  mavenCentral()
  maven("https://repo.clojars.org")
}

dependencies {
  implementation("net.java.dev.jna:jna:4.1.0")
  implementation("org.l33tlabs.twl:pngdecoder:1.0")
  implementation("org.lwjgl.lwjgl:lwjgl:2.9.3")
  implementation("slick-util:slick-util:1.0.0")

  runtimeOnly("org.lwjgl.lwjgl:lwjgl-platform:2.9.3:natives-windows")
  runtimeOnly("org.lwjgl.lwjgl:lwjgl-platform:2.9.3:natives-linux")
  runtimeOnly("org.lwjgl.lwjgl:lwjgl-platform:2.9.3:natives-osx")
}

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

application {
  mainClass = "xaos.Towns"
  applicationName = "Towns"
}

tasks.jar { manifest.attributes["Main-Class"] = "xaos.Towns" }

tasks.shadowJar {
  manifest.attributes["Main-Class"] = "xaos.Towns"
  mergeServiceFiles()
}

spotless {
  java {
    importOrder()
    removeUnusedImports()
    expandWildcardImports()
    forbidWildcardImports()
    forbidModuleImports()
    cleanthat().sourceCompatibility("21")
    googleJavaFormat()
    eclipse()
      .configFile("code-format.xml")
      .sortMembersEnabled(true)
      .sortMembersOrder("SF,F,SI,I,C,SM,M,T")
      .sortMembersVisibilityOrderEnabled(true)
      .sortMembersVisibilityOrder("B,R,D,V")
    leadingTabsToSpaces(2)
    trimTrailingWhitespace()
  }
  kotlinGradle {
    ktfmt().kotlinlangStyle().configure {
      it.setMaxWidth(120)
      it.setBlockIndent(2)
      it.setContinuationIndent(2)
      it.setRemoveUnusedImports(true)
      it.setTrailingCommaManagementStrategy(TrailingCommaManagementStrategy.COMPLETE)
    }
  }
}

fun isNonStable(version: String): Boolean {
  val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
  val regex = "^[0-9,.v-]+(-r)?$".toRegex()
  val isStable = stableKeyword || regex.matches(version)
  return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
  gradleReleaseChannel = "current"
  checkForGradleUpdate = true
  checkConstraints = false
  checkBuildEnvironmentConstraints = false
  resolutionStrategy {
    componentSelection {
      all(
        Action<ComponentSelectionWithCurrent> {
          if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
            reject("Release candidate")
          }
        }
      )
    }
  }
}
