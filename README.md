Project from 2017

# YATBRPG

## 1.What is YATBRPG
Yet Another Text Based RPG is a simple browser based RPG game (or more like a stub of a full game). It lets you evolve your hero, buy equipment and fight foes. It has been made as Spring-MVC in the backend and simple jQuery client consuming it. 

## 2. Why have I created YATBRPG
As I mentioned it’s more like a stub of the game than the game itself. I’ve created it for educational reasons and have not intended to develop it to bigger than necessary content size.
I’ve made this project to practice the technologies used and to learn how to build larger applications while keeping them somewhat understandable and possible for further expanding. I believe I partially achieved it, but since it’s my first bigger project like that I was experimenting a lot and it’s far from perfect. 

## 3. How to YATBRPG 
You can try out the game [here](https://text-browser-game.herokuapp.com).

It’s deployed on Heroku so give It a little time to run for the first time. 
Short user documentation is [here](https://drive.google.com/file/d/1Bg2R3A6xIST49riHieEwPXQcFVLImADb/view?usp=sharing) , but the game is simple and quite self-explanatory

## 4. Technologies and structure
View part is made in 2 technologies. I know it’s not how it’s supposed to be but for learning reasons I wanted to try both of the ways out. The Hero Page is served synchronously via Thymeleaf while Fight and Equipment asynchronously with JQuery.

Web service is made with Spring MVC. Project has total of 5 Controllers and corresponding Services for handling different aspects. These parts are: Home, Account, Promotion, Fight, Equipment. 

For data layer I’ve used Hibernate as ORM tool along with Spring Data.

Application is secured with Spring Security.

The flow in the nutshell:
1. When user logs in, his account data is taken from database and added to the session.
2. User can than upgrade his hero, exchange equipment and fight foes.
3. For the purpose of fighting I’ve used shallow copying of crucial hero’s data so in case of disconnection the altered in fight statistics won’t be saved as permanent.
4. When the user logs out or session expires, all the User data is saved back to Database.
