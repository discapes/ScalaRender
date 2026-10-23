ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.10.0"
val os = sys.env.get("SC_TARGET").getOrElse("linux")
val projectName = "ScalaCraft"

lazy val root = (project in file("."))
  .settings(
    name := projectName,
    // https://github.com/scalafx/scalafx-ensemble/issues/6
    run / fork := true,
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", _*) => MergeStrategy.discard
      case _                        => MergeStrategy.first
    },
    assembly / assemblyJarName := s"$projectName-$os.jar",
  )

libraryDependencies += "io.github.spair" % "imgui-java-lwjgl3" % "1.92.7.1"
libraryDependencies += "io.github.spair" % s"imgui-java-natives-$os-ft" % "1.86.11"
libraryDependencies += "commons-beanutils" % "commons-beanutils" % "1.11.0"
libraryDependencies += "org.apache.commons" % "commons-configuration2" % "2.15.1"
libraryDependencies += "org.joml" % "joml" % "1.10.9"

// https://mvnrepository.com/artifact/org.lwjgl/lwjgl/3.3.3
libraryDependencies += "org.lwjgl" % "lwjgl" % "3.4.3"
libraryDependencies += "org.lwjgl" % "lwjgl-opengl" % "3.4.3"
libraryDependencies += "org.lwjgl" % "lwjgl-glfw" % "3.4.3"
libraryDependencies += "org.lwjgl" % "lwjgl-stb" % "3.4.3"
libraryDependencies += "org.lwjgl" % "lwjgl-assimp" % "3.4.3"

libraryDependencies += "org.lwjgl" % "lwjgl" % "3.4.3" classifier s"natives-$os"
libraryDependencies += "org.lwjgl" % "lwjgl-opengl" % "3.4.3" classifier s"natives-$os"
libraryDependencies += "org.lwjgl" % "lwjgl-glfw" % "3.4.3" classifier s"natives-$os"
libraryDependencies += "org.lwjgl" % "lwjgl-stb" % "3.4.3" classifier s"natives-$os"
libraryDependencies += "org.lwjgl" % "lwjgl-assimp" % "3.4.3" classifier s"natives-$os"