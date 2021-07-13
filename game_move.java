package a;

import java.util.Scanner;

public class game_move {

	public static void main(String[] args) {
       the_game();
	}
	public static void the_game()
	{   Scanner sc = new Scanner(System.in);
	    String a;
		boolean ongoing= false;
		int player1,player2;
		Board board_game;
		board_game= new Board();
		board_game.Board_reset();
		System.out.println("players please choose one color between black and white ");
		do {
			System.out.println();
		System.out.println("the player that chose the color black will roll the dice first, please press Enter to roll the dice");
		a= sc.nextLine();
		player1= (int)((Math.random()*6)+1);
		System.out.println("dice: " + player1);
		System.out.println();
		System.out.println("the player that chose the color white will roll the dice now, please press Enter to roll the dice");
		a= sc.nextLine();
		player2 = (int)((Math.random()*6)+1);
		System.out.println("dice: " + player2);
		if(player1==player2)
		{ System.out.println();
			System.out.println("you rolled the same number ,please roll again");
		}
		}while(player1==player2);
		while(ongoing == false)
		{
			if(player1>player2)
			{
				System.out.println();
				System.out.println("color black player turn:");
				ongoing=full_game_move(0,board_game);
				if(ongoing==true)
					break;
				System.out.println();
				System.out.println("color white player turn:");
				ongoing = full_game_move(1,board_game);
				if(ongoing==true)
					break;
			}
			else
			{    
				System.out.println();
				System.out.println("color white player turn:");
				ongoing=full_game_move(1,board_game);
				if(ongoing==true)
					break;
				System.out.println();
				System.out.println("color black player turn:");
				ongoing = full_game_move(0,board_game);
				if(ongoing==true)
					break;
			}
		}
		if(board_game.getTotal_black_checkers()==0)
			System.out.println("the winner is the black color player!!!!!!!!!!!!!!!!!!!!!!!!!!");
		else
			System.out.println("the winner is the white color player!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("press Enter to play again");
		a = sc.nextLine();
		the_game();
		
	}
	public static boolean full_game_move (int color,Board b1)// make a ove with two dice rolling and return if the player wins.
	{  boolean did1,did2,did3,did4;
	Scanner sc = new Scanner(System.in);
	int dice1,dice2;
	String a;  
	System.out.println("please press enter to roll the dices");
	a= sc.nextLine();
	dice1 = (int)((Math.random()*6)+1);
	dice2 = (int)((Math.random()*6)+1);
	System.out.println("dice nimber one :  "+ dice1 + " , dice number two:  " + dice2);
	System.out.println("please press Enter to continue");
	a = sc.nextLine();
	
	b1.print_board();
	
	if(dice1==dice2)
	{  System.out.println();
		System.out.println("you had a duble dice with: " + dice1+ ", you can move 4 movments with: " + dice1);
		System.out.println("first move:");
		did1= one_dice_move(b1,color,dice1);
		if(did1 = false)
			System.out.println("no move is possible now");
		else
		{ b1.print_board();
		    System.out.println();
			System.out.println("second move:");
			did2= one_dice_move(b1,color,dice1);
			if(did2==false)
				System.out.println("you can only make one move with : " +dice1);
			else
			{
				System.out.println();
				b1.print_board();System.out.println("third move:");
				did3= one_dice_move(b1,color,dice1);
				if(did3==false)
					System.out.println("you can only make two moves with : " +dice1);
				else
				{b1.print_board();
				System.out.println();
					System.out.println("fourth move:");
					did4 = one_dice_move(b1,color,dice1);
					if(did4 == false)
						System.out.println("you can only make 3 moves with : " +dice1);
				}
			}
		}
	}
	else
	{   System.out.println();
	    System.out.println("dice nimber one :  "+ dice1 + " , dice number two:  " + dice2);
		System.out.println("prees 1 to use dice number one first, or press 2 to use dice number two first, and than press Enter");
		a = sc.nextLine();
		while(a.equals("1")==false && a.equals("2") == false)
		{   System.out.println();
			System.out.println("the key you press is incorrect ,please press the right key to continue ");
			System.out.println();
			System.out.println("first dice: " + dice1 + ", second dice: " + dice2);
			System.out.println("prees 1 to use dice number one first, or press 2 to use dice number two first, and than press Enter");
			a = sc.nextLine();
		}
		if(a.equals("1")==true)
		{  System.out.println();
			System.out.println("first move:");
			System.out.println("dice nimber one :  "+ dice1);
			did1= one_dice_move(b1,color,dice1);
			if(did1==false)
				System.out.println("the move" + dice1 +" is not possible now");
			b1.print_board();
			System.out.println();
			System.out.println("second move:");
			 System.out.println(" dice number two: " + dice2);
			did2 = one_dice_move(b1,color,dice2);
			if(did2==false)
				System.out.println("the move" + dice2 +" is not possible now");
			if(did1==false && did2 == true)
				{ b1.print_board();
System.out.println();
				System.out.println("first move again:");
				System.out.println("dice nimber one : "+ dice1);
				did1= one_dice_move(b1,color,dice1);
				if(did1==false)
					System.out.println("the move" + dice1 +" is not possible now");
				}
		}
		else
		{    System.out.println();
			System.out.println("first move:");
			 System.out.println(" dice number two: " + dice2);
			did1= one_dice_move(b1,color,dice2);
			if(did1==false)
				System.out.println("the move" + dice2 +" is not possible now");
			b1.print_board();
			System.out.println();
			System.out.println("second move:");
			 System.out.println("dice nimber one : "+ dice1);
			did2 = one_dice_move(b1,color,dice1);
			if(did2==false)
				System.out.println("tha move" + dice1 +" is not possible now");
			if(did1==false && did2 == true)
				{b1.print_board();
System.out.println();
				System.out.println("first move again:");
				 System.out.println(" dice number two: " + dice2);
				did1= one_dice_move(b1,color,dice2);
				if(did1==false)
				System.out.println("tha move" + dice2 +" is not possible now");
				}
		}
	}
	if(color == 0)
	{if(b1.getTotal_black_checkers()==0)
		return true;
	else
		return false;
	}
	else
	{if(b1.getTotal_white_checkers()==0)
		return true;
	else
		return false;
	}

	}
	public static boolean one_dice_move(Board b1, int color,int dice1)
	{

		String position;
		if(color == 0)//check if black or white
		{  System.out.println("black player turn");
			if(b1.getBlack_checker_out()==0)// check if any of the black checkers is out
			{
				if(b1.all_checkers_home(color)==false)// check if all the black checkers are home
				{       
					if(b1.any_regular_possible_move(dice1, color)==true)// check if it is any possible move
					{   position = check_and_return_position_regular(b1);
					while(b1.regular_move_checkers(color, dice1, position)==false)// check if the move from the position is legal
					{
						System.out.println("the move is not legal, please choose a different position to move from");
						position= check_and_return_position_regular(b1);
					}
					return true;
					}
					else	//when their is no possible move
						return false;
				}
				else // when all black checkers are home
				{
					System.out.println("all of your checkers at your home area");
					if(b1.check_any_position_to_move_out(color,dice1)==true)
					{position = check_and_return_position_regular(b1);
					while(b1.check_position_to_make_move_out(color, dice1, position)==false)
					{
						System.out.println("the move is not legal, please choose a different position to move from");
						position = check_and_return_position_regular(b1);
					}
					return true;
					}
					else
						return false;
				}
			}
			else // when their is black checkers out
				{System.out.println("some of your checkers has been eaten, please try to return them to the board");
				return (b1.check_if_a_move_back_in_possible_and_make_it(color, dice1));
				}
		}
		else
		{System.out.println("white player turn");
			if(b1.getWhite_checker_out()==0)// check if any of the white checkers is out
			{
				if(b1.all_checkers_home(color)==false)// check if all the white checkers are home
				{       
					if(b1.any_regular_possible_move(dice1, color)==true)// check if it is any possible move
					{   position = check_and_return_position_regular(b1);
					while(b1.regular_move_checkers(color, dice1, position)==false)// check if the move from the position is legal
					{
						System.out.println("the move is not legal, please choose a different position to move from");
						position= check_and_return_position_regular(b1);
					}
					return true;
					}
					else	//when their is no possible move
						return false;
				}
				else // when all white checkers are home
				{
					System.out.println("all of your checkers at your home area");
					if(b1.check_any_position_to_move_out(color,dice1)==true)
					{position = check_and_return_position_regular(b1);
					while(b1.check_position_to_make_move_out(color, dice1, position)==false)
					{
						System.out.println("the move is not legal, please choose a different position to move from");
						position = check_and_return_position_regular(b1);
					}
					return true;
					}
					else
						return false;
				}
			}
			else // when their is black checkers out
				{System.out.println("some of your checkers has been eaten, please try to return them to the board");
				return (b1.check_if_a_move_back_in_possible_and_make_it(color, dice1));
				}
		}
	}

	public static String check_and_return_position_regular(Board b0)// check and return a position that on the board game
	{    Scanner sc = new Scanner(System.in);
	String position;
	System.out.println("please press the letter of the position you want to advance from , choose the letter of the position without caps lock on");
	position = sc.nextLine();
	while(b0.check_position(position)==false)
	{
		System.out.println("the position is mot on the board , plaese choose a different position");
		System.out.println("please press the letter of the position you want to advance from ,choose the letter of the position without caps lock on");
		position = sc.nextLine();
	}
	return position;
	}
}
