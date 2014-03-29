import sbt._
import Keys._

object HerokuPlugin extends Plugin {
  override def settings = Seq(
    externalResolvers <<= resolvers map { appResolvers =>
      Seq(Resolver.defaultLocal) ++ appResolvers ++
      Seq(Resolver.url("heroku-sbt-typesafe") artifacts "http://217.115.68.26:8081/nexus/content/repositories/ivy-typesafe-releases/[organization]/[module]/[revision]/[type]s/[artifact](-[classifier]).[ext]",
          "heroku-central" at "http://217.115.68.26:8081/nexus/content/repositories/maven-central/",
          "typesafe" at "http://repo.typesafe.com/typesafe/repo/")
    },
    sources in doc in Compile := List()
  )
}
