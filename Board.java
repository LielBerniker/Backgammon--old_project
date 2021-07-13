package a;



public class Board { // the board game of the Backgammon game
	private Board_triangle[][] Boardgame; // Refer to the board of the game which made of board triangles on a 2x12 matrix
	private int white_checkers_out; // the checkers that belong to the white side that have been eaten by the opponent 
	private int black_checkers_out; // the checkers that belong to the black side that have been eaten by the opponent 
	private int total_black_checkers; // the total black checkers that in the game include the ones that had been eaten
	private int total_white_checkers; // the total white checkers that in the game include the ones that had been eaten
	public Board() // contractor of the board 
	{
		super();
		Boardgame =new Board_triangle[2][12];
		this.white_checkers_out = 0;
		this.black_checkers_out = 0;
		this.total_black_checkers = 15;
		this.total_white_checkers = 15;
	}
	public boolean check_if_a_move_back_in_possible_and_make_it(int color,int move)// check if a move back in is possible, and make the move.
	{
		if(color == 0)
		{
			for ( int i = 6; i < Boardgame[0].length; i++) {
				if(Boardgame[1][i].getWhite_position()==move-1)
				{
					if(Boardgame[1][i].getNumber_of_white()>1)
						return false;
					else if (Boardgame[1][i].getNumber_of_white()==1)
					{   
						Boardgame[1][i].setNumber_of_white(0);
						Boardgame[1][i].setNumber_of_black(1);
						black_checkers_out--;
						white_checkers_out++;
						return true;
					}
					else
					{
						Boardgame[1][i].setNumber_of_black(Boardgame[1][i].getNumber_of_black()+1);
						black_checkers_out--;
						return true;
					}	
				}
			}     
			return false;
		}
		else
		{
			for ( int i = 6; i < Boardgame[0].length; i++) {
				if(Boardgame[0][i].getBlack_position()==move-1)
				{
					if(Boardgame[0][i].getNumber_of_black()>1)
						return false;
					else if(Boardgame[0][i].getNumber_of_black()==1)
					{	Boardgame[0][i].setNumber_of_black(0);
					Boardgame[0][i].setNumber_of_white(1);
					white_checkers_out--;
					black_checkers_out++;
					return true;
					}
					else
					{
						Boardgame[0][i].setNumber_of_white(Boardgame[0][i].getNumber_of_white()+1);
						white_checkers_out--;
						return true;
					}
				}
			}     
			return false;
		}
	}

	public boolean check_any_position_to_move_out(int color,int move)// check if their any position possible to move from in the home area
	{
		if(color==0)
		{
			for (int i = 6; i < Boardgame[0].length; i++) {
				if(check_specific_position_to_move_out(color,move,i)==true)
					return true;
			}
		}
		else
		{
			for (int i = 6; i < Boardgame[0].length; i++) {
				if(check_specific_position_to_move_out(color,move,i)==true)
					return true;
			}
		}
		return false;
	}
	public boolean check_specific_position_to_move_out(int color,int move,int col)// check if the position its legal to make a move at the home area , and make the move
	{   

		if(color==0)
		{
			if(Boardgame[0][col].getNumber_of_black()==0)// check the number of black checkers in the position
				return false;
			else
			{
				if(move-1==Boardgame[0][col].getBlack_position())
					return true;
				else
				{
					if(Boardgame[0][col].getBlack_position()-move<0  &&  (((Boardgame[0][col-5].isBlack_home()==true && (Boardgame[0][col-5].getNumber_of_black()==0 ))|| Boardgame[0][col-5].isBlack_home()==false) && ((Boardgame[0][col-4].isBlack_home()==true && Boardgame[0][col-4].getNumber_of_black()==0 )|| Boardgame[0][col-4].isBlack_home()==false) && ((Boardgame[0][col-3].isBlack_home()==true && Boardgame[0][col-3].getNumber_of_black()==0 )|| Boardgame[0][col-3].isBlack_home()==false) && ((Boardgame[0][col-2].isBlack_home()==true && Boardgame[0][col-2].getNumber_of_black()==0 )|| Boardgame[0][col-2].isBlack_home()==false) && ((Boardgame[0][col-1].isBlack_home()==true && Boardgame[0][col-1].getNumber_of_black()==0 )|| Boardgame[0][col-1].isBlack_home()==false)))
						return true;
					else
					{
						if(Boardgame[0][col].getBlack_position()-move>=0)
						{
							if(Boardgame[0][col+move].getNumber_of_white()>1)
								return false;
							else 
								return true;	
						}
						else
							return false;
					}
				}
			}
		}
		else
		{
			if(Boardgame[1][col].getNumber_of_white()==0)// check the number of white checkers in the position
				return false;
			else
			{
				if(move-1==Boardgame[1][col].getWhite_position())
					return true;
				else
				{
					if(Boardgame[1][col].getWhite_position()-move<0  &&  (((Boardgame[1][col-5].isWhite_home()==true && (Boardgame[1][col-5].getNumber_of_white()==0 ))|| Boardgame[1][col-5].isWhite_home()==false) && ((Boardgame[1][col-4].isWhite_home()==true && Boardgame[1][col-4].getNumber_of_white()==0 )|| Boardgame[1][col-4].isWhite_home()==false) && ((Boardgame[1][col-3].isWhite_home()==true && Boardgame[1][col-3].getNumber_of_white()==0 )|| Boardgame[1][col-3].isWhite_home()==false) && ((Boardgame[1][col-2].isWhite_home()==true && Boardgame[1][col-2].getNumber_of_white()==0 )|| Boardgame[1][col-2].isWhite_home()==false) && ((Boardgame[1][col-1].isWhite_home()==true && Boardgame[1][col-1].getNumber_of_white()==0 )|| Boardgame[1][col-1].isWhite_home()==false)))
						return true;
					else
					{
						if(Boardgame[1][col].getWhite_position()-move>=0)
						{
							if(Boardgame[1][col+move].getNumber_of_black()>1)
								return false;
							else 
								return true;	
						}
						else
							return false;
					}
				}
			}
		}
	}
	public boolean check_position_to_make_move_out(int color,int move,String position1)// check if the position its legal to make a move at the home area , and make the move
	{   boolean flag=false;
	int i;
	if(color==0)
	{
		for ( i = 6; i < Boardgame[0].length; i++) {
			if(Boardgame[0][i].getPosition().equals(position1)==true)
			{ flag = true;
			break;}
		}
		if(flag == false)
			return false;
		else
		{
			if(Boardgame[0][i].getNumber_of_black()==0)// check the number of black checkers in the position
				return false;
			else
			{
				if(move-1==Boardgame[0][i].getBlack_position())
				{
					Boardgame[0][i].setNumber_of_black(Boardgame[0][i].getNumber_of_black()-1);
					total_black_checkers--;
					return true;
				}
				else
				{    
					if(Boardgame[0][i].getBlack_position()-move<0  &&  (((Boardgame[0][i-5].isBlack_home()==true && (Boardgame[0][i-5].getNumber_of_black()==0 ))|| Boardgame[0][i-5].isBlack_home()==false) && ((Boardgame[0][i-4].isBlack_home()==true && Boardgame[0][i-4].getNumber_of_black()==0 )|| Boardgame[0][i-4].isBlack_home()==false) && ((Boardgame[0][i-3].isBlack_home()==true && Boardgame[0][i-3].getNumber_of_black()==0 )|| Boardgame[0][i-3].isBlack_home()==false) && ((Boardgame[0][i-2].isBlack_home()==true && Boardgame[0][i-2].getNumber_of_black()==0 )|| Boardgame[0][i-2].isBlack_home()==false) && ((Boardgame[0][i-1].isBlack_home()==true && Boardgame[0][i-1].getNumber_of_black()==0 )|| Boardgame[0][i-1].isBlack_home()==false)))
					{
						Boardgame[0][i].setNumber_of_black(Boardgame[0][i].getNumber_of_black()-1);
						total_black_checkers--;
						return true;
					}
					else 
					{
						if(Boardgame[0][i].getBlack_position()-move>=0)
						{
							if(Boardgame[0][i+move].getNumber_of_white()>1)
								return false;
							else if(Boardgame[0][i+move].getNumber_of_white()==1)
							{
								Boardgame[0][i].setNumber_of_black(Boardgame[0][i].getNumber_of_black()-1);
								Boardgame[0][i+move].setNumber_of_white(0);
								white_checkers_out++;
								Boardgame[0][i+move].setNumber_of_black(1);
								return true;
							}
							else
							{
								Boardgame[0][i].setNumber_of_black(Boardgame[0][i].getNumber_of_black()-1);
								Boardgame[0][i+move].setNumber_of_black(Boardgame[0][i+move].getNumber_of_black()+1);
								return true;
							}	
						}
						else
							return false;
					}
				}
			}
		}
	}
	else
	{
		for ( i = 6; i < Boardgame[0].length; i++) {
			if(Boardgame[1][i].getPosition().equals(position1)==true)
			{ flag = true;
			break;}
		}
		if(flag == false)
			return false;
		else
		{
			if(Boardgame[1][i].getNumber_of_white()==0)// check the number of white checkers in the position
				return false;
			else
			{
				if(move-1==Boardgame[1][i].getWhite_position())
				{
					Boardgame[1][i].setNumber_of_white(Boardgame[1][i].getNumber_of_white()-1);
					total_white_checkers--;
					return true;
				}
				else
				{
					if(Boardgame[1][i].getWhite_position()-move<0  &&  (((Boardgame[1][i-5].isWhite_home()==true && (Boardgame[1][i-5].getNumber_of_white()==0 ))|| Boardgame[1][i-5].isWhite_home()==false) && ((Boardgame[1][i-4].isWhite_home()==true && Boardgame[1][i-4].getNumber_of_white()==0 )|| Boardgame[1][i-4].isWhite_home()==false) && ((Boardgame[1][i-3].isWhite_home()==true && Boardgame[1][i-3].getNumber_of_white()==0 )|| Boardgame[1][i-3].isWhite_home()==false) && ((Boardgame[1][i-2].isWhite_home()==true && Boardgame[1][i-2].getNumber_of_white()==0 )|| Boardgame[1][i-2].isWhite_home()==false) && ((Boardgame[1][i-1].isWhite_home()==true && Boardgame[1][i-1].getNumber_of_white()==0 )|| Boardgame[1][i-1].isWhite_home()==false)))
					{
						Boardgame[1][i].setNumber_of_white(Boardgame[0][i].getNumber_of_white()-1);
						total_white_checkers--;
						return true;
					}
					else
					{
						if(Boardgame[1][i].getWhite_position()-move>=0 )
						{

							if(Boardgame[1][i+move].getNumber_of_black()>1)
								return false;
							else if(Boardgame[1][i+move].getNumber_of_black()==1)
							{
								Boardgame[1][i].setNumber_of_white(Boardgame[1][i].getNumber_of_white()-1);
								Boardgame[1][i+move].setNumber_of_black(0);
								black_checkers_out++;
								Boardgame[1][i+move].setNumber_of_white(1);
								return true;
							}
							else
							{
								Boardgame[1][i].setNumber_of_white(Boardgame[1][i].getNumber_of_white()-1);
								Boardgame[1][i+move].setNumber_of_white(Boardgame[1][i+move].getNumber_of_white()+1);
								return true;
							}	
						}
						else
							return false;
					}
				}
			}
		}
	}
	}
	public boolean regular_move_checkers(int color,int move, String position1)// return true or false if the move is possibole and make the move
	{
		int row=0,col=0;
		for (int i = 0; i < Boardgame.length; i++) {
			for (int j = 0; j < Boardgame[0].length; j++) {
				if(Boardgame[i][j].getPosition().equals(position1)== true)
				{
					if(color==0)
					{
						if(Boardgame[i][j].getNumber_of_black()>0)
						{row = i;
						col = j;
						return (regular_move_chekers_now(move,color,row,col));
						}
						else
							return false;
					}
					else
					{
						if(Boardgame[i][j].getNumber_of_white()>0)
						{row = i;
						col = j;
						return (regular_move_chekers_now(move,color,row,col));
						}
						else
							return false;
					}
				}}}

		return false;
	}
	public boolean regular_move_chekers_now(int move,int color,int row,int column )// return true or false if a move from a specific position is possible and make the move 
	//- 0 refer to black move, 1 refer to white move
	{

		if(color == 0)
		{
			if (Boardgame[row][column].getBlack_position()-move<0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getBlack_position()==(Boardgame[row][column].getBlack_position()-move))
						{
							if (Boardgame[i][j].getNumber_of_black()>0 || Boardgame[i][j].getNumber_of_white()<=1)
							{
								if(Boardgame[i][j].getNumber_of_white()==1)
								{Boardgame[i][j].setNumber_of_white(Boardgame[i][j].getNumber_of_white()-1);
								white_checkers_out =  white_checkers_out +1;}
								Boardgame[row][column].setNumber_of_black(Boardgame[row][column].getNumber_of_black()-1);
								Boardgame[i][j].setNumber_of_black(Boardgame[i][j].getNumber_of_black()+1);
								return true;}
							else
								return false;}}}
				return false;}}
		else
		{
			if (Boardgame[row][column].getWhite_position()-move<0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getWhite_position()==(Boardgame[row][column].getWhite_position()-move))
						{
							if (Boardgame[i][j].getNumber_of_white()>0 || Boardgame[i][j].getNumber_of_black()<=1)
							{
								if(Boardgame[i][j].getNumber_of_black()==1)
								{Boardgame[i][j].setNumber_of_black(Boardgame[i][j].getNumber_of_black()-1);
								black_checkers_out =  black_checkers_out +1;}
								Boardgame[row][column].setNumber_of_white(Boardgame[row][column].getNumber_of_white()-1);
								Boardgame[i][j].setNumber_of_white(Boardgame[i][j].getNumber_of_white()+1);
								return true;}
							else
								return false;}}}
				return false;}}
	}
	public boolean all_checkers_home(int color)// checks if all of the checkers in the color are in their home area - 0 refer to black move, 1 refer to white move
	{
		if(color==0)
		{
			if(black_checkers_out>0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getNumber_of_black()>0 && Boardgame[i][j].isBlack_home()==false)
							return false;}}
				return true;}}
		else
		{
			if(white_checkers_out>0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getNumber_of_white()>0 && Boardgame[i][j].isWhite_home()==false)
							return false;}}
				return true;}}
	}
	public boolean any_regular_possible_move(int move,int color) // check if the move from any position is even possible - 0 refer to black move, 1 refer to white move
	{
		if(color == 0)
		{
			for (int i = 0; i < Boardgame.length; i++) {
				for (int j = 0; j < Boardgame[0].length; j++) {
					if(Boardgame[i][j].getNumber_of_black()>0)
					{if(regular_possible_move(move,color,i,j)==true)
						return true;}
				}
			}
			return false;}		
		else{
			for (int i = 0; i < Boardgame.length; i++) {
				for (int j = 0; j < Boardgame[0].length; j++) {
					if(Boardgame[i][j].getNumber_of_white()>0)
					{if(regular_possible_move(move,color,i,j)==true)
						return true;}
				}
			}
			return false;}
	}
	public boolean regular_possible_move(int move,int color,int row,int column )// check if a move fron a specific position is possible - 0 refer to black move, 1 refer to white move
	{
		if(color == 0)
		{
			if (Boardgame[row][column].getBlack_position()-move<0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getBlack_position()==(Boardgame[row][column].getBlack_position()-move))
						{
							if (Boardgame[i][j].getNumber_of_black()>0 || Boardgame[i][j].getNumber_of_white()<=1)
								return true;
							else
								return false;}
					}
				}
				return false;}
		}
		else
		{
			if (Boardgame[row][column].getWhite_position()-move<0)
				return false;
			else
			{
				for (int i = 0; i < Boardgame.length; i++) {
					for (int j = 0; j < Boardgame[0].length; j++) {
						if(Boardgame[i][j].getWhite_position()==(Boardgame[row][column].getWhite_position()-move))
						{
							if (Boardgame[i][j].getNumber_of_white()>0 || Boardgame[i][j].getNumber_of_black()<=1)
								return true;
							else
								return false;}
					}
				}
				return false;}	
		}
	}

	public void print_board()// print the current state of the game board
	{
		System.out.println();
		System.out.println("                                                            |      ------>>>>       black player home                   |");
		System.out.println("                                                            |                                                           |");
		System.out.println("|____A____|____B____|____C____|____D____|____E____|____F____|____G____|____H____|____I____|____J____|____K____|____L____|");
		System.out.println("________________________________________________________________________________________________________________________");
		System.out.print("|");
		for (int i = 0; i < Boardgame[0].length; i++) {
			if(Boardgame[0][i].getNumber_of_black()>0)
				System.out.print(" black:"+ Boardgame[0][i].getNumber_of_black() + " |");
			else if(Boardgame[0][i].getNumber_of_white()>0)
				System.out.print(" white:"+ Boardgame[0][i].getNumber_of_white() + " |");
			else
				System.out.print("         |");}
		System.out.println();
		System.out.println("|                                                                                                                       |");
		System.out.println("|                                                                                                                       |");
		System.out.println("|_______________________________________________________________________________________________________________________|");
		System.out.println("|                                                                                                                       |");
		System.out.println("|                                                                                                                       |");
		System.out.println("|                                                                                                                       |");
		System.out.print("|");
		for (int i = 0; i < Boardgame[0].length; i++) {
			if(Boardgame[1][i].getNumber_of_black()>0)
				System.out.print(" black:"+ Boardgame[1][i].getNumber_of_black() + " |");
			else if(Boardgame[1][i].getNumber_of_white()>0)
				System.out.print(" white:"+ Boardgame[1][i].getNumber_of_white() + " |");
			else
				System.out.print("         |");}
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|____M____|____N____|____O____|____P____|____Q____|____R____|____S____|____T____|____U____|____V____|____W____|____X____|");
		System.out.println("                                                            |                                                           |");
		System.out.println("                                                            |     ------->>>>      white player home                    |");
		System.out.println();
		System.out.println("total of black checkers in the game: " + total_black_checkers + "   black checkers that have been eaten: " +black_checkers_out);
		System.out.println("total of white checkers in the game: " + total_white_checkers + "   white checkers that have been eaten: " +white_checkers_out);
	}

	public boolean check_position(String position1) // check if the position even exist
	{
		for (int i = 0; i < Boardgame.length; i++) {
			for (int j = 0; j < Boardgame[0].length; j++) {
				if(Boardgame[i][j].getPosition().equals(position1)==true)
					return true;
			}	
		}
		return false;
	}
	public int getTotal_black_checkers() // get the total number of black checkers in the game 
	{return total_black_checkers;
	}
	public void setTotal_black_checkers(int total_black_checkers) //set the total number of black checkers in the game
	{this.total_black_checkers = total_black_checkers;
	}
	public int getTotal_white_checkers() // get the total number of white checkers in the game
	{return total_white_checkers;
	}
	public void setTotal_white_checkers(int total_white_checkers) // set the total number of white checkers in the game
	{this.total_white_checkers = total_white_checkers;
	}
	public void Board_reset() // reset the board game to the start of the Backgammon game
	{
		int i=0;
		for (int j = 0; j < Boardgame[0].length; j++) {


			if(j==0) Boardgame[i][j] = new Board_triangle(0,5,false,false,"a",11,12);
			else if(j==1) Boardgame[i][j] = new Board_triangle(0,0,false,false,"b",10,13);
			else if(j==2) Boardgame[i][j] = new Board_triangle(0,0,false,false,"c",9,14);
			else if(j==3) Boardgame[i][j] = new Board_triangle(0,0,false,false,"d",8,15);
			else if(j==4) Boardgame[i][j] = new Board_triangle(3,0,false,false,"e",7,16);
			else if(j==5) Boardgame[i][j] = new Board_triangle(0,0,false,false,"f",6,17);
			else if(j==6) Boardgame[i][j] = new Board_triangle(5,0,true,false,"g",5,18);
			else if(j==7) Boardgame[i][j] = new Board_triangle(0,0,true,false,"h",4,19);
			else if(j==8) Boardgame[i][j] = new Board_triangle(0,0,true,false,"i",3,20);
			else if(j==9) Boardgame[i][j] = new Board_triangle(0,0,true,false,"j",2,21);
			else if(j==10) Boardgame[i][j] = new Board_triangle(0,0,true,false,"k",1,22);
			else  Boardgame[i][j] = new Board_triangle(0,2,true,false,"l",0,23);

		}
		i=1;
		for (int j = 0; j < Boardgame[0].length; j++)
		{
			if(j==0) Boardgame[i][j] = new Board_triangle(5,0,false,false,"m",12,11);
			else if(j==1) Boardgame[i][j] = new Board_triangle(0,0,false,false,"n",13,10);
			else if(j==2) Boardgame[i][j] = new Board_triangle(0,0,false,false,"o",14,9);
			else if(j==3) Boardgame[i][j] = new Board_triangle(0,0,false,false,"p",15,8);
			else if(j==4) Boardgame[i][j] = new Board_triangle(0,3,false,false,"q",16,7);
			else if(j==5) Boardgame[i][j] = new Board_triangle(0,0,false,false,"r",17,6);
			else if(j==6) Boardgame[i][j] = new Board_triangle(0,5,false,true,"s",18,5);
			else if(j==7) Boardgame[i][j] = new Board_triangle(0,0,false,true,"t",19,4);
			else if(j==8) Boardgame[i][j] = new Board_triangle(0,0,false,true,"u",20,3);
			else if(j==9) Boardgame[i][j] = new Board_triangle(0,0,false,true,"v",21,2);
			else if(j==10) Boardgame[i][j] = new Board_triangle(0,0,false,true,"w",22,1);
			else  Boardgame[i][j] = new Board_triangle(2,0,false,true,"x",23,0);

		}
	}
	public Board_triangle[][] getBoardgame() // get the current board game
	{return Boardgame;
	}
	public void setBoardgame(Board_triangle[][] boardgame) // set the game board
	{Boardgame = boardgame;
	}
	public int getWhite_checker_out() // get how many white checkers have been eaten 
	{return white_checkers_out;
	}
	public void setWhite_checker_out(int white_checker_out) // set how many white checkers have been eaten 
	{this.white_checkers_out = white_checker_out;
	}
	public int getBlack_checker_out() // get how many black checkers have been eaten 
	{return black_checkers_out;
	}
	public void setBlack_checker_out(int black_checker_out)// set how many black checkers have been eaten 
	{this.black_checkers_out = black_checker_out;
	}

}
