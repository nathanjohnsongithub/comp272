class Main {

  /*
   * Main Driver for personalized testing. 
   * 
   * Do *NOT* forget to run the supplied tests before submitting 
   * your work. The supplied tests can be found under the replit 
   * 'tools' panel, marked as 'tests'.
   */
  
    public static void main(String[] args)
    {
        LUCLinkedList list = new LUCLinkedList();
      
        // Insert the values
        list.insert(2);
        list.insert(3);
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(6);
        list.insert(3);
        list.insert(3);
        list.insert(9);
        list.insert(10);
        list.insert(35);
      
        System.out.println(list); 
        list.removeElementsLT(15);
        System.out.println(list);

    }
}
