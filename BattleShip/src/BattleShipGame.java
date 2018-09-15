import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleShipGame {

	public static void main(String[] args) {
		
		System.out.println("Welcome To BattleShip Game.");
		System.out.println("This is your playing grid.");
		
		int[][] arr=new int[10][10];
		List<Integer> StoreCoordinate = new ArrayList<>();
		List<Integer> GuessedCoordinatePlayers = new ArrayList<>();
		List<Integer> GuessedCoordinateComputers = new ArrayList<>();
		printgrid(arr);
		DeployPlayersShip(StoreCoordinate,arr);
		printgrid(arr);
		DeployComputersShip(StoreCoordinate,arr);
		int computer=5,player=5;
		while(computer>0&&player>0) {
		PlayersTurn(GuessedCoordinatePlayers,arr);
		ComputersTurn(GuessedCoordinateComputers,arr);
		printgrid(arr);
		player=count(1,arr);
		computer=count(2,arr);
		}
		System.out.println("GAME OVER");
		player=count(1,arr);
		computer=count(2,arr);
		if(computer==0) {
			System.out.println("Hooray!You win the battle.");
			System.out.println("Your Ships : "+ player +" | Computers Ship : "+ computer);
		}
		else if(player==0) {
			System.out.println("Sad!You lost the battle.");
			System.out.println("Your Ships : "+ player +" | Computers Ship : "+ computer);
		}
		
	}
	public static int count(int i,int[][] arr) {
		int count=0;
		for(int j=0;j<10;j++) {
			for(int k=0;k<10;k++) {
				if(arr[j][k]==i) {count++;}
			}
		}
		return count;
	}
	public static void ComputersTurn(List<Integer> GuessedCoordinateComputers,int[][] arr) {
		System.out.println("COMPUTER'S TURN");
		Random rand = new Random();
		int count=1;
		while(count<=1) {int x=rand.nextInt(9);
						 int y=rand.nextInt(9);
			if(GuessedCoordinateComputers.contains(x*10+y)==true) {continue;}
		if(arr[y][x]==1) {System.out.println("The Computer sunk one of your ships!");
							arr[y][x]=-1;
							GuessedCoordinateComputers.add(x*10+y);
							count++;
		}
		else if(arr[y][x]==2) {System.out.println("The Computer sunk one of its own ships");
							arr[y][x]=-2;
							GuessedCoordinateComputers.add(x*10+y);
							count++;
		}
		else if(arr[y][x]==0){System.out.println("Computer missed");
							GuessedCoordinateComputers.add(x*10+y);
							count++;
		}
		}
	}
	public static void PlayersTurn(List<Integer> GuessedCoordinatePlayers,int[][] arr) {
		Scanner scan=new Scanner(System.in);
		System.out.println("YOUR TURN");
		int count=1;
		while(count>=1) {
		System.out.println("Enter X coordinate");
		int x=scan.nextInt();
		System.out.println("Enter Y coordinate");
		int y=scan.nextInt();
			if(x<0||x>9||y<0||y>9) {System.out.println("Invalid Position");
				continue;}
			if(GuessedCoordinatePlayers.contains(x*10+y)==true) {continue;}
			if(arr[y][x]==2) {System.out.println("Boom! You sunk the ship!");
			arr[y][x]=-2;
			count--;
			GuessedCoordinatePlayers.add(x*10+y);
			
			}
			else if(arr[y][x]==1) {System.out.println("Oh no, you sunk your own ship :(");
			GuessedCoordinatePlayers.add(x*10+y);
			arr[y][x]=-1;
			count--;
			}
			else if(arr[y][x]==0) {System.out.println("Sorry, you missed");
			GuessedCoordinatePlayers.add(x*10+y);
			arr[y][x]=-10;
			count--;
		}
		}
		
	}
	public static void DeployComputersShip(List<Integer> 
	 StoreCoordinate,int[][] arr) {
		System.out.println("Computer is deploying ships");
		Random rand = new Random();
		int count=1;
		while(count<=5) {
		int x=rand.nextInt(9);
		int y=rand.nextInt(9);
		if(StoreCoordinate.contains(x*10+y)==false) {
			StoreCoordinate.add(x*10+y);
			arr[y][x]=2;
			System.out.println("Computer ship deployed");
			count++;}
		}
		System.out.println("All computer ships deployed.");
	}
	public static void DeployPlayersShip(List<Integer> 
	 StoreCoordinate,int[][] arr) {
		System.out.println("Deploy your ships");
		Scanner sc=new Scanner(System.in);
		int i=1;
		while(i<=5){
		System.out.print("Enter x coordinate: ");
		int x=sc.nextInt();
		System.out.print("Enter y coordinate: ");
		int y=sc.nextInt();
		
		if(x<0||x>9||y<0||y>9) {System.out.println("Invalid position");
			continue;}
		if(StoreCoordinate.contains(x*10+y)==false) {
		StoreCoordinate.add(x*10+y);
		arr[y][x]=1;
		System.out.println("Your ship deployed");
		i++;}
		else {System.out.println("Ship already exist.Try again!");}
		}
		System.out.println("All five ships are deployed");
		
	}
	public static void printgrid(int[][] arr) {
		for(int head=-2;head<10;head++) {
			if(head<0){System.out.print(" ");}
			
			
			else System.out.print(head);
		}
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(i+"|");
			for(int j=0;j<10;j++) {
				if(arr[i][j]==0) {
					System.out.print(" ");
					continue;
				}
				else if(arr[i][j]==1) {System.out.print("@");}
				else if(arr[i][j]==2) {System.out.print(" ");}
				else if(arr[i][j]==-2) {System.out.print("!");}
				else if(arr[i][j]==-1) {System.out.print("x");}
				else if(arr[i][j]==-10) {System.out.print("-");}
			}
			System.out.println("|"+i);
		}
		for(int head=-2;head<10;head++) {
			if(head<0){System.out.print(" ");}
			
			
			else System.out.print(head);
		}
		System.out.println();
		int player=count(1,arr);
		int computer=count(2,arr);
		System.out.println("Your Ships : "+ player+ " | Computers Ship : "+ computer);
        System.out.println();
	}

}
