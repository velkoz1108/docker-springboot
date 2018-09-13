## docker 构建微服务

### 第一种 在pom.xml中添加Docker插件
docker 构建插件 (三种插件 spotify  fabric8io  bibryam)

    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.1.1</version>
        <configuration>
            <imageName>velkoz/velkoz-f5</imageName>
            <baseImage>java</baseImage>
            <entryPoint>["java","-jar","/${project.build.finalName}.jar"]</entryPoint>
            <resources>
                <resource>
                    <targetPath>/</targetPath>
                    <directory>${project.build.directory}</directory>
                    <include>${project.build.finalName}.jar</include>
                </resource>
            </resources>
        </configuration>
    </plugin>

执行 mvn clean package docker:build


### 第二种 插件读取Dockerfile进行构建
指定dockerfile文件路径

    
    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.1.1</version>
        <configuration>
            <imageName>velkoz/velkoz-f5</imageName>
            <dockerDiretory>${project.basedir}/src/main/docker</dockerDiretory>
            <entryPoint>["java","-jar","/${project.build.finalName}.jar"]</entryPoint>
            <resources>
                <resource>
                    <targetPath>/</targetPath>
                    <directory>${project.build.directory}</directory>
                    <include>${project.build.finalName}.jar</include>
                </resource>
            </resources>
        </configuration>
    </plugin>