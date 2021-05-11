flutter 打包aar 长传到远程仓库 的步骤

1，找到flutter工程的Android目录 ，找到Flutter文件夹下面的build.gradle

2，在文件的底部添加，如下脚本文件

apply plugin: 'maven'
uploadArchives {
    repositories {
        mavenDeployer {
            本地的Maven地址设置为../repos
             repository(url: uri('../repo'))
            远程的Maven地址设置为 http://10.21.177.81:8081/nexus/content/repositories/releases/
            repository(url: "http://10.21.177.81:8081/nexus/content/repositories/releases/") {
                authentication(userName: "maven_dev", password: "maven")
            }
            //设置插件的GAV参数
            pom.groupId = 'com.yiban.flutter'
            pom.artifactId = 'FlutterSearch'
            pom.version = '1.0.0'
        }
    }
}

3，执行打包命令,自动上传到远程仓库
./gradlew uploadArchives

4，添加引用， 在引用工程的build.gradle 文件中添加如下脚本
        表示仓库的地址
        maven{
            url 'http://10.21.177.81:8081/nexus/content/repositories/releases/'
        }
        flutter的下载地址
        maven {
            url 'http://download.flutter.io'
        }
        
5，在app.build文件中添加依赖

implementation 'com.yiban.flutter:FlutterSearch:1.0.0'



