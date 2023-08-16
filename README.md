# SuperEvelyn_Java-Game

** GAME DESCRIPTION **

Super Evelyn is a 2D platformer-type game inspired by the movie Everything All At Once by the Daniels.
This movie is centered around Evelyn and her family (husband and daughter Joy). Throughout the film, Evelyn
travels the multiverse and acquires different skills in order to save her Joy from ruining her life. During one
of her multiverse travels (called jumps in the movie), she enters a universe where the conditions were not favorable
for life to form and becomes a rock. The game is set in that universe.

Overall the aim of the game is for the player (Evelyn) to collect all three eyes in order to join and
find Joy at the end of the concourse. There are rewards in the shape of googly eyes that increase the score
of the player and in order to win, you must get all three.

The controls are the arrow keys (right, and left) and also the space-bar or up key to jump to avoid the enemies.
So far the point of the game is simple, in the future it would be nice to make the black bagel villain more
interesting and to also make Evelyn be able to avoid them.

//** Instructions **//

To run the game, all the packages must be present. When playing, you can jump however, it is not necessary at the
moment for this version of the game. To start the game again, exit the program and run again. Once you see the second
rock, the game is over. You can explore more but the game mission is over. The game is run through the main class.

//** Sprites and Graphics **//

I designed all the game graphics myself with an online pixel drawing website. The reference pictures I used to make
the Evelyn rock was a scene from the movie; the same goes for the desert background. Since Evelyn is just a rock,
I kept the animations simple, with her googly eyes moving up and down as she jumps.

The flag at the beginning of the game indicates the starting point and the Joy rock at the end indicates the end.

//** Game Mechanics **//

- The Animations: The game has animations for how the rock moves and jumps. The animations are implemented in
the sprite class and called in the paintComponents.
- Interactiveness: The game uses the arrow keys and the space bar to make the rock move.
- Scoring Mechanism: Because the game is about collecting the eyes, the amount of eyes is shown to the player
at the top right of the screen.
- Ending Mechanism: The game is ended when all three eyes are collected and you see the rock Joy.
- Physical mechanism: Gravity is implemented in the Evelyn class and is used when she is jumping. The method jump
raises the y-cords of the rock player.
- Collision detection: There is collision detection as when Evelyn comes into contact with the eyes, they disappear
and go into the score.
- Creativity: There is not game centered around the movie Everything Everywhere All at Once and this game shows one
of many possibilities of games that could be made based on the film's amazing plot.
- Flourish: the flourish I worked on is the graphics that I designed myself.


//** Description of Classes **//

Main Package:

- mainClass: The mainClass is where the game is run.
- Game: This is where the GameWindow and GamePanel are put into one and form a complete game.
- GameWindow: This is the frame of the game where the settings for the size of the window, properties like where
the window will be on your screen and if it is on top of other tabs or not.
- GamePanel: This is the class where I painted all the images and visual parts of the game. There is
 a method to move background instead of the player when the arrow keys are pressed. This gives the illusion of
 a smoother and more dynamic background.
 - GameThread: A thread is necessary to run the repaint task at a rate that the human eye can see. I was able to
 control the refresh rate of the game (sort of like frames per second) in this class.
 - Score: This is the class that defines what the score is made of.

 Inputs Package:

 - KeyboardInputs: In this class, the function of the arrow keys and the space bar are set.

 Sprites Package:

 - Sprite: In this class, the general attributes of a sprite image are set like height, width, x, y. The animation
 method is also in this method because originally I was planning to make more that one player, so in that case it is
 more effective to put animation as a sprite thing, rather than just in the Evelyn class.

 - Evelyn: This is class that specifically defines the player character. Because only she can jump, the jump method
 is defined here. To implement the jump, I split the action into three parts, pre jump, during-jump, and after-jump.
 The collision detection  methods are also defined here. These are simple, if Evelyn's x or y-coordinates are equal
 to the items, there is collision and a boolean is returned true.

 Villain Package:

 - Bagel: Although not completed, this class defines the properties of the bagel villain. In updates of the game,
 I want to add animation for this character and also maybe some powers and movement to it.

Enjoy playing!
