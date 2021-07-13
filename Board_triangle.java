package a;

public class Board_triangle // refer to the triangle of the board
{private int number_of_black; // current number of the black checkers in the triangle
private int number_of_white; // current number of the white checkers in the triangle
private boolean black_home; // define the black home
private boolean white_home; // define the white home
private String general_position; // refer to the general position that the user see
private int white_position; // refer to the position from the start of the white movement 
private int black_position; // refer to the position from the start of the black movement 

public Board_triangle(int number_of_black, int number_of_white, boolean black_home, boolean white_home, String position,int black_position,int white_position)// contractor of the board triangle
{super();
this.number_of_black = number_of_black;
this.number_of_white = number_of_white;
this.black_home = black_home;
this.white_home = white_home;
this.general_position = position;
this.black_position = black_position;
this.white_position = white_position;
}
public int getWhite_position() // get the position in the white movement
{return white_position;
}
public void setWhite_position(int white_position) // set the position in the white movement
{this.white_position = white_position;
}
public int getBlack_position() // get the position in the black movement
{return black_position;
}
public void setBlack_position(int black_position) // set the position in the black movement
{this.black_position = black_position;
}
public boolean isBlack_home()// get if black home
{return black_home;
}
public void setBlack_home(boolean black_home)// set if black home
{this.black_home = black_home;
}
public boolean isWhite_home() // get if white home
{return white_home;
}
public void setWhite_home(boolean white_home)// set if white home
{this.white_home = white_home;
}
public String getPosition()// get general position
{return general_position;
}
public void setPosition(String position)// set general position
{this.general_position = position;
}
public int getNumber_of_black() // get general number of black checkers in the game
{return number_of_black;
}
public void setNumber_of_black(int number_of_black) // set general number of black checkers in the game
{this.number_of_black = number_of_black;
}
public int getNumber_of_white() // get general number of white checkers in the game
{return number_of_white;
}
public void setNumber_of_white(int number_of_white) // set general number of white checkers in the game
{this.number_of_white = number_of_white;
}

}
