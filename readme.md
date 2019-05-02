
<p align="center">
  <img src="https://cdn.abranhe.com/projects/racefx/racefx.png" height="100">
  <h3 align="center">RaceFx</h3>
  <p align="center">A JavaFX racing game with betting capabilities<p>
	<p align="center"><a href="https://github.com/abranhe"><img src="https://abranhe.com/badge.svg"></a> <a href="https://cash.me/$abranhe"><img src="https://cdn.abranhe.com/badges/cash-me.svg"></a> <a href="https://www.patreon.com/abranhe"><img src="https://cdn.abranhe.com/badges/patreon.svg" /></a> <a href="https://paypal.me/abranhe/10"><img src="https://cdn.abranhe.com/badges/paypal.svg" /></a>

</p>

## Get RaceFx

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/80px-Apple_logo_black.svg.png" height="70">                      
  <img src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/98c2d592-fb7a-4383-adf4-8fcea016dc75/d5kepm9-66efb2f9-b8f0-40c1-80f4-1c656fadad0a.png/v1/fill/w_894,h_894,strp/official_windows_8_logo_by_n_studios_2_d5kepm9-pre.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAwMCIsInBhdGgiOiJcL2ZcLzk4YzJkNTkyLWZiN2EtNDM4My1hZGY0LThmY2VhMDE2ZGM3NVwvZDVrZXBtOS02NmVmYjJmOS1iOGYwLTQwYzEtODBmNC0xYzY1NmZhZGFkMGEucG5nIiwid2lkdGgiOiI8PTEwMDAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.CqvRNi-nw9NhMOafdrdlveBP5w2O9dEbrY3QJgGW5oM" height="90">
  <h4 align="center"><a href="https://github.com/abranhe/racefx/releases/latest">Download for MacOS</a>                  <a href="https://github.com/abranhe/racefx/releases/latest">Download for Windows</a></h4>
</p>


## Contribute

Clone or download the repository and open it on your favorite Java IDE. I recomend [Netbeans](https://netbeans.org/) since it was written on it.

```
$ git clone https://github.com/abranhe/racefx.git && cd racefx
```

<p align="center">
	<img src="https://cdn.abranhe.com/projects/racefx/screenshot.png" height="500">
</p>

Add your cool feature and submit a pull request. This project I made it back when I was learning, I wanted to fix it a little and make a whole new project out of it.

```
$ git checkout -b your-feature master
```

## What it does?

Write a JavaFX project (extend JavaFX application) that implements a robot racing animation with betting capabilities. The application must contain/do the following:

- Size 600 x 600 pixels.
- Robot themed race tract.
- Be multithreaded.
- 5 robots with different numbers (you can use pictures if necessary) or design your own (be
creative).
- A button to start the race and a button to reset the race.
- A text field to enter a betting amount (whole dollars only max. $1000).
- A text field to enter the number of the robot the user is betting on (validate 1..5).
- When the application starts, all robots are on the left of the screen, at least 20 pixels away from
each other.
- When the start race button is pressed, the robots will start running from left to right until they
reach the right side of the scene.
- Randomize the movement of the robots so they don’t all move at the same speed. This will add
some unpredictability to the game. Your game needs to be able to detect when a robot has reached
the end of the race track and record the order of arrival of the robots.
- When all the robots have finished the race, check if the robot the user bet on is in first, second or
third place.
    - If the robot the user bet on finished in first place, the user won his/her betting amount *
$1000. Display a message congratulating him/her and showing the amount won.
    - If the robot the user bet on finished in second place, the user won his/her betting amount *
$500. Display a message congratulating him/her and showing the amount won.
    - If the robot the user bet on finished in third place, the user won his/her betting amount *
$250. Display a message congratulating him/her and showing the amount won.
- If the robot the user bet on finished in fourth place, display a message informing the user of this
fact


<p align="center">
	<img src="https://i.postimg.cc/9MXzS59X/racefx.gif">
</p>

## License
 
[Apache Software Foundation](https://github.com/abranhe/RaceFx/blob/master/license) © [Abraham Hernandez](https://github.com/abranhe)
