<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Eranga-Bandara/fuel-pass-clone-app">
  <p align="center">
  <img src="">
</p>

  </a>

<h1 align="center">FUEL PASS APP CLONE</h1>

  <p align="center">
    A Java Fx clone application for national fulepass application
    <br />
    <a href="https://github.com/Eranga-Bandara/mini-game"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://eranga-bandara.github.io/mini-game/">View Demo</a>
    ·
    <a href="https://github.com/Eranga-Bandara/mini-game/issues">Report Bug</a>
    ·
    <a href="https://github.com/Eranga-Bandara/mini-game/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#Version">Version</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![product-screenshot](/src/main/resources/images/img/splash-screen.png)

Sri Lanka Ministry of Power and Energy launched the [National Fuel Pass App](https://fuelpass.gov.lk/) to provide the public a convenient and easily accessible solution to obtain fuel and facilitate an allocation-based fuel distribution method.
I created a clone version of this National Fuel Pass app to improve  my Java and JavaFX skills.
I developed this clone app as a desktop application.

You may also suggest changes by forking this repo and creating a pull request or opening an issue.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

I used following technologies to build this project.

- ![Java](https://img.shields.io/badge/-Java-orange)
- ![JavaFX](https://img.shields.io/badge/-JavaFX-yellowgreen)
- ![Maven](https://img.shields.io/badge/-Maven-red)
- ![FXML](https://img.shields.io/badge/-FXML-lightgrey)
- ![CSS](https://img.shields.io/badge/-CSS-blue)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Please follow the below instructions for setting up the project locally.

### Prerequisites

- Before get started, you must have Java 11 installed on your computer. You can download Java 11 from [oracle website](https://www.oracle.com/java/technologies/downloads/#java11).
Then, follow the instructions given for [installation](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A).
- Next you need to install [Maven](https://maven.apache.org/download.cgi).

### Installation

_Follow the instructions below on setting up the Fuel Pass App Clone project._


1. Clone the repo
   ```sh
   git clone https://github.com/Eranga-Bandara/fuel-pass-clone-app.git
   ```
2. Open a terminal from the cloned project location. 
Then run the following command to create an executable jar file.

   ```sh
   mvn clean package
   ```
3. Then locate the fuel-pass-app-clone.jar file and use the following command to execute the file.

   ```sh
   java -jar fuel-pass-app-clone.jar
   ```



<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE -->
## Usage

The application starts with the following splash screen.

![splash-screen](/src/main/resources/images/img/splash-screen.png)

After opening the application you will see the welcome window. It contains two main buttons for registration and login.
Before accessing the application, you must register.
![welcome-window](/src/main/resources/images/img/welcome-page.png)

When you click the register button the following registration window will pop up.

![registration-window](/src/main/resources/images/img/registration-page.png)

Here you need to provide valid National Identity Card Number, First Name, Last Name and Address to register with the application.
After successfully completing these fields you will be redirected to the login window below.

![login-window](/src/main/resources/images/img/login-page.png)

Now you can enter the National ID number provided for registration to log into the app.
If you have successfully logged in, you will be able to see your profile information and your assigned fuel quota in the user dashboard.
The user dashboard provides options to download and print the generated QR code for you. This QR code contains your National ID number and name.

![user-dashboard](/src/main/resources/images/img/user-dashboard.png)

By clicking on the top right icon you can open the admin login window below. (Admin Password: 123)

![admin-login-window](/src/main/resources/images/img/admin-login-page.png)

In the Admin Control Center you can view all currently registered users.
The search field can be used to search for specific users and you can update the fuel quota by selecting a row in the table.

![admin-control-center](/src/main/resources/images/img/admin-control-center.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Copyright &copy;2022 Eranga Bandara. All Rights Reserved.<br>
License under the [MIT License](LICENSE.txt).

<p align="right">(<a href="#readme-top">back to top</a>)</p> 


<!-- Version -->
### Version
0.1.0

<p align="right">(<a href="#readme-top">back to top</a>)</p> 

<!-- CONTACT -->
## Contact

Eranga Bandara - [@linkedin](https://www.linkedin.com/in/eranga-bandara-75667b15a/) - erangab@yahoo.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Choose an Open Source License](https://choosealicense.com/)
* [SceneBuilder](https://gluonhq.com/products/scene-builder/)
* [Img Shields](https://shields.io)


<p align="right">(<a href="#readme-top">back to top</a>)</p>