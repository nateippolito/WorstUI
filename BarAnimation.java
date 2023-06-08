import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarAnimation extends JFrame {
    public Timer timer;
    public boolean direction=true;
    public boolean run=true;
    int x;
    int vol;
    public JLabel volLabel;
    public JLabel tellLabel;
    public BarAnimation() {
        vol=0;
        tellLabel=new JLabel("Click to Stop!");
        volLabel=new JLabel("Volume : "+vol);
        volLabel.setLocation(0,0);
        setTitle("Volume");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        timer=new Timer(1,new tickPerformer());
        x=0;
        timer.start();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                add(volLabel);
                add(tellLabel);
                g.setColor(Color.red);
                g.fillRect(50,180,125,40);
                g.setColor(Color.orange);
                g.fillRect(175,180,125,40);
                g.setColor(Color.yellow);
                g.fillRect(300,180,125,40);
                g.setColor(Color.green);
                g.fillRect(425,180,125,40);
                g.setColor(Color.black);
                g.drawRect(50,180,500,40);
                
                g.fillRect(x,180,10,40);
                repaint();
                this.addMouseListener(new PointListener());
            }
        };

        add(panel);
        setVisible(true);
    }
    public class tickPerformer implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          tick();
        }
    }
    
        public void tick(){
            if(run)
                move();

           vol=(x-50)/5;
           volLabel.setText("Volume: "+vol);
        }
        
        public void move(){
            
            if(x==540)
            direction=false;
            if(x==50)
            direction=true;
            if(direction==true)
                x+=5;
            else if(direction==false)
                x-=5;
               
        }
        
    public static void main(String[] args) {
       new BarAnimation();

    }
    private class PointListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
        
}

		@Override
		public void mouseEntered(MouseEvent e) {
		
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			run=false;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			run=true;
		}
    }
}
