package emailapp;

class frm extends EmailApp {

  public frm(String firsName, String lastName, String phoneNumber) {
    super(firsName, lastName, phoneNumber);
  }

  public static void main(String[] args){
    MyFrame f = new MyFrame();
    f.setVisible(true);

  }
}