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
            <dockerDirectory>${project.basedir}/src/main/docker</dockerDirectory>
            <resources>
                <resource>
                    <targetPath>/</targetPath>
                    <directory>${project.build.directory}</directory>
                    <include>${project.build.finalName}.jar</include>
                </resource>
            </resources>
        </configuration>
    </plugin>
    
    

### 第三种 执行mvn clean package时，就构建
phase和goal可以这样理解： maven命令格式是：mvn phase:goal ,例如mvn package docker：build
那么package和docker都是phase，build则是goal