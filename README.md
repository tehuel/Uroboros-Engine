# Uroboros Engine
Uroboros Engine is a Java 2D game development Framework, with the aim of bringing the universe of the creation of video games to students or freelance programmers.

### Prerequisites

* Eclipse >= ***Neon***.
* Java development kit >= ***8***.

### Getting Started

First of all, it is necessary to have a Java IDE with Maven plugin installed.

Start by creating a new Maven project.

It is important to set the project to use Java 8.

	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<source>8</source>
					<target>8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>

It will be necessary to import Uroboros Engine as a dependency of it. (It is necessary to have imported the Uroboros Engine framework in the workspace previously).

	<dependencies>
		<dependency>
			<groupId>org.team-uroboros</groupId>
			<artifactId>uroboros-engine</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
	</dependencies>	

It will be necessary to set as VM Parameter ***-Dsun.java2d.opengl = true***, to fix perfonmance issues and strange behaviors.

### My First Game

To create my first game, we will need to create a class that inherits from the Game class.
This class will need to be assigned an initial Scene, which must be a class that inherits from it.

public class MainScene extends Scene {

	public MainScene() {

	}

}

public class MyGame extends Game {

	public MyGame() {
		super(new MainScene());
	}

}

Finally, create a Main Method and use the GameLauncher class to launch our game.


public class MyGame extends Game {

	public MyGame() {
		super(new MainScene());
	}

	public static void main(String[] args) {
		GameLauncher.launch(new MyGame());
	}

}

If you can see a black screen, it means that the framework is working.


#### Contributing

TODO

#### Versioning

TODO

#### Changelog

TODO

  
#### Authors

* **[Team Uroboros](https://github.com/TeamUroboros/Uroboros-Engine)**