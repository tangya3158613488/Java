package exercise12_28;

class Book{
	Book(String str){
	System.out.println(str +" constructor"); }
	}
	class ComputerBook extends Book{
	ComputerBook(String str){
	super("Book");
	System.out.println(str +" constructor"); }
	}
	class ProgramBook extends ComputerBook{
	ProgramBook(){
	super("ComputerBook");
	System.out.println("ProgramBook constructor");
	}
	public static void main(String[] args) {
	ProgramBook pb=new ProgramBook();
	}
}
