package com.flash.ATM_Machine;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InputMachine implements ActionListener{
	
    double number, answer;
	int calculation;
	Dao dao = new Dao(); //Dao class object used to connect to database

	String name;
	int pin;
	double damount;
	double wamount;
	double balance;
	double balance2;
	int transferAmount;
	int VerificationAccount;
	int account_no;
	int transfer_acc;
     
	JFrame frame = new JFrame("ATM Machine"); //Frame object is made 
	Container c;  
	PreparedStatement ps;
	
	//Setting up gui 
	//Addding button to container
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
	JTextField textField1 = new JTextField();
	JTextArea area = new JTextArea();

	JButton clear = new JButton("CLEAR");
	JButton cancel = new JButton("CANCEL");
	JButton enter = new JButton("ENTER");
    
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	
	JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
	
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
	
	JButton zero = new JButton("0");
	
	JButton none1 = new JButton(" ");
	JButton none2 = new JButton(" ");
	JButton none3 = new JButton(" ");
	
	JButton deposite = new JButton("Deposite");
	JButton widraw = new JButton("Widraw");
	JButton transfer = new JButton("Transfer");
	JButton CP = new JButton("Change PIN");
	JButton INQ = new JButton("Balance INQ");
	
	JButton EnterAgain = new JButton("Enter");
	JButton DepositeCash = new JButton("Enter");
	JButton CashWidraw = new JButton("Enter");
	JButton test = new JButton("Enter");
	JButton test2 = new JButton("Enter");
	
	
	Connection con;
	ResultSet rs;
	
	
	public void startATM(){
		textField1.setText("");
		enter.setVisible(true);
		ATMGUI();
		ATMComponent();
		ComponentAction();
	}
	
	public Connection setConnection() throws ClassNotFoundException, SQLException {
		con = dao.getCon();
		return con;
		
	}
	//setting frame for application
	public void ATMGUI(){
		frame.setBounds(350,100,1300,900);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void ATMComponent(){
		//Adding componect to Atm application
		c = frame.getContentPane();
		c.setLayout(null);
	   
		l1.setBounds(200,230,700,50);
		l1.setText("-- Enter your Card no --");
	    l1.setFont(new Font("Arial",Font.BOLD,25));
	    l1.setVisible(true);
	    c.add(l1);
	    
	    
	    textField1.setBounds(275,320,200,50);
	    textField1.setFont(new Font("Arial",Font.BOLD,20));
	    textField1.setHorizontalAlignment(0);
	    textField1.setVisible(true);
	    c.add(textField1);

		
		zero.setBounds(1010,440,70,55);
	    zero.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(zero);
	    
	    one.setBounds(930,230,70,55);
	    one.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(one);
	    
	    
	    two.setBounds(1010,230,70,55);
	    two.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(two);
	    
	    three.setBounds(1090,230,70,55);
	    three.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(three);
	     
		four.setBounds(930,300,70,55);
		four.setFont(new Font("Arial",Font.BOLD,20));
		c.add(four);
	    
	    five.setBounds(1010,300,70,55);
	    five.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(five);
	    
	    six.setBounds(1090,300,70,55);
	    six.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(six);
	    
	    
	    seven.setBounds(930,370,70,55);
	    seven.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(seven);
	    
	    eight.setBounds(1010,370,70,55);
	    eight.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(eight);
	       
	    nine.setBounds(1090,370,70,55);
	    nine.setFont(new Font("Arial",Font.BOLD,20));
	    c.add(nine);
	    
	    none1.setBounds(930,440,70,55);
	    none1.setEnabled(false);
	    c.add(none1);
	    
	    none2.setBounds(1090,440,70,55);
	    none2.setEnabled(false);
	    c.add(none2);
	    
	    none3.setBounds(1170,440,100,55);
	    none3.setEnabled(false);
	    c.add(none3);
	    
	    cancel.setBounds(1170,230,100,55);
	    cancel.setFont(new Font("Arial",Font.BOLD,14));
	    cancel.setBackground(Color.RED);
	    c.add(cancel);
	    
	       
	    clear.setBounds(1170,300,100,55);
	    clear.setFont(new Font("Arial",Font.BOLD,14));
	    clear.setBackground(Color.yellow);
	    c.add(clear);
	    
	    enter.setBounds(1170,370,100,55);
	    enter.setFont(new Font("Arial",Font.BOLD,14));
	    enter.setBackground(Color.green);
	    c.add(enter);
	    
   
	    deposite.setBounds(100,200,200,40);
	    deposite.setFont(new Font("Arial",Font.BOLD,14));
	    deposite.setVisible(false);
	    c.add(deposite);    
	    
	    widraw.setBounds(500,200,200,40);
	    widraw.setFont(new Font("Arial",Font.BOLD,14));
	    widraw.setVisible(false);
	    c.add(widraw);
	    
	    transfer.setBounds(100,350,200,40);
	    transfer.setFont(new Font("Arial",Font.BOLD,14));
	    transfer.setVisible(false);
	    c.add(transfer);
	    
	    CP.setBounds(500,350,200,40);
	    CP.setFont(new Font("Arial",Font.BOLD,14));
	    CP.setVisible(false);
	    c.add(CP);
	    
	    INQ.setBounds(295,500,200,40);
	    INQ.setFont(new Font("Arial",Font.BOLD,14));
	    INQ.setVisible(false);
	    c.add(INQ);
	    
	    area.setBounds(100,200,400,300);
	    area.setFont(new Font("Arial",Font.BOLD,14));
	    area.setVisible(false);
	    c.add(area);
	    
	}
	//Defifne component action
    public void ComponentAction() {
    	
		clear.addActionListener(this);
		cancel.addActionListener(this);
		enter.addActionListener(this);
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		
		deposite.addActionListener(this);
		widraw.addActionListener(this);
		INQ.addActionListener(this);
		CP.addActionListener(this);
		transfer.addActionListener(this);
		

	}
	//Handling event or add functionality to buttons
	public void actionPerformed(ActionEvent e) {
   		
		Object source = e.getSource();
		
		if(source == clear){
			int length = textField1.getText().length();
			int number = length-1;
			
			if(length>0) {
				StringBuffer back = new StringBuffer(textField1.getText());
				back.deleteCharAt(number);
				textField1.setText(back.toString());	
			}
		}
		else if(source == cancel) {
			startATM();
		}
		else if(source == zero) {
			if(textField1.getText().equals("0")) {
				return;
			}
			else {
				textField1.setText(textField1.getText()+"0");
			}
			
		}
		else if(source == one) {
			textField1.setText(textField1.getText()+"1");
		}
		else if(source == two) {
			textField1.setText(textField1.getText()+"2");
		}
		else if(source == three) {
			textField1.setText(textField1.getText()+"3");
		}
		else if(source == four) {
			textField1.setText(textField1.getText()+"4");
		}
		else if(source == five) {
			textField1.setText(textField1.getText()+"5");
		}
		else if(source == six) {
			textField1.setText(textField1.getText()+"6");
		}
		else if(source == seven) {
			textField1.setText(textField1.getText()+"7");
		}
		else if(source == eight) {
			textField1.setText(textField1.getText()+"8");
		}
		else if(source == nine) {
			textField1.setText(textField1.getText()+"9");
		}		
		else if(source == enter) {
			
			try {
				VerificationAccount = Integer.parseInt(textField1.getText());
				
				con = setConnection();
				ps = con.prepareStatement("Select * from newBanking where account = '"+textField1.getText()+"'");
				rs = ps.executeQuery();
				
				if(rs.next()) {
					hide();
				}
				else {
					JOptionPane.showMessageDialog(null,"Sorry! Your Account_no is incorrect");
					textField1.setText("");
				}
			} catch (SQLException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else if(source == deposite) {   //deposite cash  
			deposite.setVisible(false);
			widraw.setVisible(false);
			transfer.setVisible(false);
			CP.setVisible(false);
			INQ.setVisible(false);
			enter.setVisible(false);
			
			
			
			l1.setText("       --  ENTER PIN  --   ");
			l1.setVisible(true);
			textField1.setText("");
			textField1.setVisible(true);
			
			
			EnterAgain.setBounds(1170,370,100,55);
		    EnterAgain.setBackground(Color.green);
		    EnterAgain.setFont(new Font("Arial",Font.BOLD,14));
		    c.add(EnterAgain);
		    
			EnterAgain.setVisible(true);
			EnterAgain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			            try {
				           	con = setConnection(); //connecting to database
							ps = con.prepareStatement("Select * from newBanking where pin = '"+textField1.getText()+"'");
							rs = ps.executeQuery();
							if(rs.next()) {
								balance = rs.getDouble(7);
							    account_no = rs.getInt(1);
							    if(account_no == VerificationAccount) {
							    	EnterAgain.setVisible(false);
							    	l1.setText("      -- Enter Amount --");
							    	textField1.setText("");
							    	
							    	DepositeCash.setBounds(1170,370,100,55);
							    	DepositeCash.setBackground(Color.green);
								    DepositeCash.setFont(new Font("Arial",Font.BOLD,14));
								  
								    c.add(DepositeCash);
								    DepositeCash.setVisible(true);
								    
								    ps = con.prepareStatement("update newBanking set damount = ?,balance = ? where account = ?");//Executing update query
								    
								    DepositeCash.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
										    damount = Double.parseDouble(textField1.getText());
										    if(damount <= 10000) {
										    	balance += damount;
										        System.out.println(balance);
										    	try {
													ps.setDouble(1,damount);
													ps.setDouble(2,balance);
													ps.setInt(3,account_no);
												
													int res = ps.executeUpdate();
													if(res >= 1) {
														JOptionPane.showMessageDialog(null,"Cash Deposite Successfully");
													    System.exit(1);
													}
												} catch (SQLException e1) {
													e1.printStackTrace();
												}
										    }
										    else {
										         JOptionPane.showMessageDialog(null,"Sorry you can't deposite more then 10000 once");			 
										    }
										}
									});
								    	
							    }
							    else{
							    	JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
							    	textField1.setText("");
							    }
							    
							}else {
								JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
								textField1.setText("");
							}
						
						} catch (SQLException | ClassNotFoundException e1) {
								e1.printStackTrace();
						}
						
					}
				});
		    
	    }
		//widraw cash 
		else if(source == widraw) {
			
			deposite.setVisible(false);
			widraw.setVisible(false);
			transfer.setVisible(false);
			CP.setVisible(false);
			INQ.setVisible(false);
			enter.setVisible(false);
			
			
			
			l1.setText("       -- ENTER PIN --   ");
			l1.setVisible(true);
			textField1.setText("");
			textField1.setVisible(true);
			
			
			EnterAgain.setBounds(1170,370,100,55);
		    EnterAgain.setFont(new Font("Arial",Font.BOLD,14));
		    EnterAgain.setBackground(Color.green);
		    c.add(EnterAgain);
		    
			EnterAgain.setVisible(true);
			EnterAgain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			            try {
				           	con = setConnection(); //connecting to database
							ps = con.prepareStatement("Select * from newBanking where pin = '"+textField1.getText()+"'");
							rs = ps.executeQuery();
							if(rs.next()) {
								balance = rs.getDouble(7);
							    account_no = rs.getInt(1);
							    if(account_no == VerificationAccount) {
							    	EnterAgain.setVisible(false);
							    	l1.setText("     -- Enter Amount --");
							    	textField1.setText("");
							    	
							    	CashWidraw.setBounds(1170,370,100,55);
							    	CashWidraw.setBackground(Color.green);
							    	CashWidraw.setFont(new Font("Arial",Font.BOLD,14));
								    c.add(CashWidraw);
								    
								    CashWidraw.setVisible(true);
								    
								    ps = con.prepareStatement("update newBanking set wamount = ?,balance = ? where account = ?");
								    
								    CashWidraw.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
										    wamount = Double.parseDouble(textField1.getText());
										    if(wamount < balance && wamount<10000) {
										    	balance -= wamount;
										    	try {
													ps.setDouble(1,wamount);
													ps.setDouble(2,balance);
													ps.setInt(3,account_no);
												
													int res = ps.executeUpdate();
													if(res >= 1) {
														JOptionPane.showMessageDialog(null,"Cash Widraw Successfully ");
													    System.exit(1);
													}
												} catch (SQLException e1) {
													
													e1.printStackTrace();
												}
										    }
										    else {
										         JOptionPane.showMessageDialog(null,"Sorry widrawalbe amount is more then 10000 or insufficent balance");	
										         textField1.setText("");
										    }
										}
									});
								    	
							    }
							    else{
							    	JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
							    	textField1.setText("");
							    }
							    
							}else {
								JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
								textField1.setText("");
							}
						
						} catch (SQLException | ClassNotFoundException e1) {
								e1.printStackTrace();
						}
						
					}
				});
		}
		
		else if(source == INQ) {
			deposite.setVisible(false);
			widraw.setVisible(false);
			transfer.setVisible(false);
			CP.setVisible(false);
			INQ.setVisible(false);
			enter.setVisible(false);
			
			
			
			
			l1.setText("         -- ENTER PIN --   ");
			l1.setVisible(true);
			textField1.setText("");
			textField1.setVisible(true);
			
			
			EnterAgain.setBounds(1170,370,100,55);
			EnterAgain.setBackground(Color.green);
		    EnterAgain.setFont(new Font("Arial",Font.BOLD,14));
		    c.add(EnterAgain);
		    
			EnterAgain.setVisible(true);
			EnterAgain.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					 	con = setConnection();
						ps = con.prepareStatement("Select * from newBanking where pin = '"  +textField1.getText()+"'");
						rs = ps.executeQuery();
						
						if(rs.next()) {
							account_no = rs.getInt(1);
						    if(account_no == VerificationAccount) {
						    	EnterAgain.setVisible(false);
						    	textField1.setVisible(false);
						    	balance = rs.getDouble(7);
						        
						    	l1.setText("Your Current Balance: "+balance);
						    	   	
						    }
						    else{
						    	
								   JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
								   textField1.setText("");
						    }
						}
						else {
							 JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
							 textField1.setText("");
						}
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		     
		}
		//adding transfer button functionality
		else if(source == transfer) {
			deposite.setVisible(false);
			widraw.setVisible(false);
			transfer.setVisible(false);
			CP.setVisible(false);
			INQ.setVisible(false);
			enter.setVisible(false);
			
 
			l1.setText("        -- ENTER PIN --   ");
			l1.setVisible(true);
			textField1.setText("");
			textField1.setVisible(true);
			
			
			EnterAgain.setBounds(1170,370,100,55);
			EnterAgain.setBackground(Color.green);
		    EnterAgain.setFont(new Font("Arial",Font.BOLD,14));
		    c.add(EnterAgain);
		    
			EnterAgain.setVisible(true);
			EnterAgain.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						con = setConnection();
						ps = con.prepareStatement("Select * from newBanking where pin = '"  +textField1.getText()+"'");
						rs = ps.executeQuery();
						
						if(rs.next()) {
							account_no = rs.getInt(1);
							balance = rs.getDouble(7);
							if(account_no == VerificationAccount) {
								EnterAgain.setVisible(false);
						    	l1.setText("-- Account to which transfer --");
						    	textField1.setText("");
						    	
						    	test.setBounds(1170,370,100,55);
						    	test.setBackground(Color.green);
							    test.setFont(new Font("Arial",Font.BOLD,14));
							    test.setVisible(true);
							    c.add(test);
							    
							    ps = con.prepareStatement("Select * from newBanking where account = ?");
							    
							    test.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										transfer_acc = Integer.parseInt(textField1.getText());
										try {
											ps.setInt(1, transfer_acc);
											rs = ps.executeQuery();
											if(rs.next()){
												balance2 = rs.getDouble(7);
												test.setVisible(false);
												l1.setText("     -- Enter Amount --");
										    	textField1.setText("");
										    	
										    	test2.setBounds(1170,370,100,55);
										    	test2.setBackground(Color.green);
											    test2.setFont(new Font("Arial",Font.BOLD,14));
											    test2.setVisible(true);
											    c.add(test2);
											    
											    
											    test2.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent e) {
														try {
															ps = con.prepareStatement("update newBanking set balance = ? where account = ?");
															transferAmount = Integer.parseInt(textField1.getText());
															if(balance>=transferAmount) {
																balance = balance - transferAmount;
																ps.setDouble(1,balance);
																ps.setInt(2,account_no);
																ps.executeUpdate();
															}
															else {
																 JOptionPane.showMessageDialog(null,"Sorry! Not Sufficent Balance");
																 System.exit(1);
															}
															ps = con.prepareStatement("update newBanking set balance = ? where account = ?");
															balance2 += transferAmount;
															ps.setDouble(1,balance2);
															ps.setInt(2,transfer_acc);
															int res = ps.executeUpdate();
															if(res>=1) {
																JOptionPane.showMessageDialog(null,"Money transfer Successfully");
																System.exit(1);
															}
		
															
														} catch (SQLException e1) {
															e1.printStackTrace();
														}
																
													}
												});
												
											}else {
												 JOptionPane.showMessageDialog(null,"Sorry! No Such Account exist");
												 textField1.setText("");
											}
										} catch (SQLException e1) {
											e1.printStackTrace();
										}
										
									}
								});
							}
						}else {
							 JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
							 textField1.setText("");
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
			});
		}
		//Adding functionality to changePin button
		else if(source == CP) {
			deposite.setVisible(false);
			widraw.setVisible(false);
			transfer.setVisible(false);
			CP.setVisible(false);
			INQ.setVisible(false);
			enter.setVisible(false);
			

			l1.setText("        -- ENTER PIN --   ");
			l1.setVisible(true);
			textField1.setText("");
			textField1.setVisible(true);
			
			
			EnterAgain.setBounds(1170,370,100,55);
			EnterAgain.setBackground(Color.green);
		    EnterAgain.setFont(new Font("Arial",Font.BOLD,14));
		    c.add(EnterAgain);
		    
			EnterAgain.setVisible(true);
			EnterAgain.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				    try {
				    	con = setConnection();  //connecting to database
						ps = con.prepareStatement("Select * from newBanking where pin = '"  +textField1.getText()+"'");
						rs = ps.executeQuery();
						
						if(rs.next()) {
						    account_no = rs.getInt(1);
						    if(account_no == VerificationAccount) {
						    	EnterAgain.setVisible(false);
						    	l1.setText("      -- Enter New Pin --");
						    	textField1.setText("");
						    	
						    	test.setBounds(1170,370,100,55);
						    	test.setBackground(Color.green);
							    test.setFont(new Font("Arial",Font.BOLD,14));
							  
							    c.add(test);
							    test.setVisible(true);
							    
							    ps = con.prepareStatement("update newBanking set pin = ? where account = ?");
							    test.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										   
										String new_pin = textField1.getText();
										if(new_pin.length() == 4) {
											pin = Integer.parseInt(new_pin);
											try {
												ps.setInt(1, pin);
												ps.setInt(2, account_no);
												int res = ps.executeUpdate();
												if(res>=1) {
													JOptionPane.showMessageDialog(null,"Congrats! Your PIN has been changed");
													System.exit(1);
												}
											} catch (SQLException e1) {
												e1.printStackTrace();
											}
											
										}
										else {
											JOptionPane.showMessageDialog(null,"Sorry! PIN must be of 4 degin");
											textField1.setText("");	
										}						
										
									}
								});
						    }else {
						    	JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
								textField1.setText("");
						    }
						}else {
							 JOptionPane.showMessageDialog(null,"Sorry! Your Pin is incorrect");
							 textField1.setText("");
						}
				    }catch(Exception ex) {
				    	ex.printStackTrace();
				    }
				}
			});
			
			
		}
		
	}

	public void hide() {
		l1.setVisible(false);
		textField1.setVisible(false);
		
		deposite.setVisible(true);
		widraw.setVisible(true);
		transfer.setVisible(true);
		CP.setVisible(true);
		INQ.setVisible(true);
		
	}
	

}