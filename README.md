# OddOrEven Engine

This program determines whether a given number is odd or even, but in an absurd way.

The project was inspired by this image: https://i.imgur.com/RGLFim0.png

## How It Works

1. When an OddOrEven object is constructed, a minimum and maximum range is set (defaults to 0 and 100, respectively). 
2. These ranges are then passed to a method that will generate JavaScript that will later be interpreted by Java's built-in ScriptEngine. 
3. The generated script contains only one function: 'isEven(n)', and checks if n is equal to every even number between min and max.
4. If the engine discovers a number less than the minimum or larger than the maximum, it will regenerate the script to account for the new range.
5. The generated JavaScript is then ran, and the result is returned back to Java.

Note: This will throw a StackOverflowError if the engine's range is too large. I plan to keep that in as a joke.
