description = "Build quick-product-import to executable jar"
group = "net.glyphstone"
version = "1.0.1"


plugins {
    id("base")
    kotlin("jvm") version "1.3.72"
    java

}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.create<Jar>( "fatJar") {
    description = "Builds a fat jar with all dependencies that can be executed with java -jar ..."
    group  = "Build"
    setBaseName( "importer" )
    manifest {
        attributes["Main-Class"] = "net.glyphstone.quick.MainKt"
    }

    val sourcesMain = sourceSets.main.get()
    // sourcesMain.allSource.forEach { println("add from sources: ${it.name}") }
    from(sourcesMain.output)

    configurations.runtimeClasspath.filter {
        it.name.endsWith(".jar")
    }.forEach { jar ->
        from(zipTree(jar))
    }

}
