import java.util.Random;

public class Main
{
	private BinarySearchTree<Person> tree;
	private Random rdm;
	
	public Main()
	{
		rdm = new Random();
		
		int length = 5;
		String category = "name";
		
		
		Person[] people = new Person[length];
		
		for (int i = 0; i < length; i++)
		{
			people[i] = generatePerson();
			people[i].setComparable(category);
			System.out.println(people[i].getNachname()+" "+people[i].getVorname());
		}
		
		tree = generateTree(people);
		
		System.out.println("########## Sortierter Bereich ############");
		System.out.println("Es wird nach "+people[0].getComparable()+" sortiert:");
	
		inOrderSysout(tree);
	}
	
	public Person generatePerson()
	{
		String[] names = {"Meier", "Peters", "Krämer","Münstermann","Hock","Kunert"};
		String[] forenames = {"Carsten","Balthasar","Enrike","Giesela","Günther","Britta","Peter","Kunibert"};
		
		Person person = new Person();
		
		person.setNachname(names[rdm.nextInt(names.length)]);
		person.setVorname(forenames[rdm.nextInt(forenames.length)]);
		
		return person;
	}
	
	public BinarySearchTree<Person> generateTree(Person[] people)
	{
		BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
		for (Person p: people)
		{
			tree.insert(p);
			
		}
		return tree;
	}
	
	public void inOrderSysout(BinarySearchTree<Person> tree)
	{
		if (!tree.isEmpty())
		{
			inOrderSysout(tree.getLeftTree());
			System.out.println(tree.getContent().getNachname()+" "+tree.getContent().getVorname());
			inOrderSysout(tree.getRightTree());
		}
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
}
