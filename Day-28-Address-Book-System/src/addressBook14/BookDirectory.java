package addressBook14;
	import java.io.IOException;
	import java.util.*;

	public class BookDirectory {
		static Scanner sc = new Scanner(System.in);
		Map<String, AddressBook> mainAddressBook =  new Hashtable<>();
		void dirNavigator() {
			boolean toggle = true;
			while (toggle) {
				System.out.println("""
						MAIN ADDRESS BOOK

						1 -> Create New Book
						2 -> Display Book
						3 -> Open A book
						4 -> Search People
						5 -> Read Book from File
						6 -> Write Book to File
						0 -> Exit
						""");
				System.out.print("Choice: ");
				int choice = sc.nextInt();
				System.out.println("============================= \n");
				switch (choice) {
				case 1 -> {
					System.out.println("What do you want to call this book? (Space Character not supported):");
					String name = sc.next();
					openBook1(name);
					System.out.println("============================= \n");
				}
				case 2 -> {
					displayBooks1();
					System.out.println("============================= \n");
				}
				case 3 -> {
					System.out.println("Enter the Book Name to be opened: ");
					String bookName = sc.next();
					System.out.println("============================= \n");
					openBook1(bookName).bookNavigator();
				}
				case 4 -> {
					int option = searchMenu();
					handleSearchChoice(option);
				}
				case 5 -> {
					System.out.println("What do you want to call this book?: ");
					String bookName = sc.next();
					readBook1(bookName);  //should add this file
					System.out.println(bookName + " added to Main Address Book. \n");
				}
				case 6 -> {
					System.out.println("Enter the Book Name to be stored: ");
					String bookName = sc.next();
					AddressBook thisBook = openBook1(bookName);
				}
//					try {
//						writeBook(thisBook);
//					} catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
//						((Throwable) e).printStackTrace();
//					}
//					System.out.println("Book stored!");
//				}
				case 0 -> {
					System.out.println("Main Book Closed.");
					toggle = false;
				}
				default -> {
					System.out.println("Enter Correct choice.");
					System.out.println("============================= \n");
				}
				}
			}
		}
		private void displayBooks1() {
			// TODO Auto-generated method stub
			
		}
		private void readBook1(String bookName) {
			// TODO Auto-generated method stub
			
		}
		private AddressBook openBook1(String bookName) {
			// TODO Auto-generated method stub
			return null;
		}
		int searchMenu(){
			System.out.println("""
					Filter people by:
					1 -> City
					2 -> State
					""");
			System.out.print("Choice: ");
			return sc.nextInt();
		}
		void handleSearchChoice(int choice){
			switch (choice){
			case 1 -> {
				System.out.print("\n");
				System.out.println("Enter city: ");
				String city = sc.next();
				List<Contact> citizens = filterCity(city);
				System.out.print("\n");
				System.out.println("========Found "+ citizens.size() + " contact in " + city + "========");
				citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getFirstName()));
				System.out.println("============================= \n");
			}
			case 2 -> {
				System.out.println("Enter state: ");
				String state = sc.next();
				List<Contact> citizens = filterState(state);
				System.out.println("\n ========Found "+ citizens.size() + " people in" + state + "========");
				citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getFirstName()));
				System.out.println("============================= \n");
			}
			}
		}
		List<Contact> filterCity(String city) {
			List<Contact> citizens = new ArrayList<>();
			for (Map.Entry<String, AddressBook> books : mainAddressBook.entrySet()) {
				List<Contact> entryContact = books.getValue().entry;
				List<Contact> filteredContacts = entryContact.stream()
						.filter(person -> person.getClass().equals(city))
						.toList();
				citizens.addAll(filteredContacts);
			}
			return citizens;
		}
		List<Contact> filterState(String state) {
			List<Contact> citizens = new ArrayList<>();
			for (Map.Entry<String, AddressBook> books : mainAddressBook.entrySet()) {
				List<Contact> entryContact = books.getValue().entry;
				List<Contact> filteredContacts = entryContact.stream()
						.filter(person -> person.getState().equals(state))
						.toList();
				citizens.addAll(filteredContacts);
			}
			return citizens;
		}
		void newBook(String name){
			mainAddressBook.put(name, new AddressBook(name));
			System.out.println("Created book named " + name);
		}
		void displayBooks(){
			System.out.println(mainAddressBook.toString());
		}
		AddressBook openBook(String name){
			return mainAddressBook.get(name);
		}
		//Temporary Method
		void addAddressBook(AddressBook ab){
			mainAddressBook.put(ab.bookName, new AddressBook(ab.bookName));
		}
		@Override
		public String toString() {
			return "BookDirectory{" +
					"mainAddressBook=" + mainAddressBook + "\n" +
					'}';
		}
		void readBook(String bookName) throws IOException{
			AddressBookCSVIO reader = new AddressBookCSVIO();
			ArrayList<Contact> newList = null;
			newList = reader.readData();
			mainAddressBook.put(bookName, new AddressBook(bookName, newList));
		}

		//void writeBook(AddressBook book) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
			AddressBookCSVIO writer = new AddressBookCSVIO();{
			//writer.writeData(book.entry);
			//        writer.writeData();
			System.out.println("""
					Store as:
					1 -> .csv file
					2 -> .json file
					""");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			Object book;
			switch (choice){
			case 1 -> {
				AddressBookCSVIO writer1 = new AddressBookCSVIO();
			//	writer1.writeData(book.entry);
			}
			case 2-> {
				JSONIO writer1 = new JSONIO();
				//writer1.writeDataJSON(book.entry);
				}
			}
		}
}
