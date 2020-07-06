public class myThread extends Thread {
    String name;
    Picture mandle;
    Mandlebrot test;
    int halfHeight, halfWidth;
    double x;
    double y;
    double zoom;
    double downBound, upBound, leftBound, rightBound;
    Mandlebrot one, two, three, four;
    boolean isSectorOne, isSectorTwo, isSectorThree, isSectorFour;

    public void sectorOne(double zoom) throws InterruptedException {
        for (; zoom > 6.7e-13; zoom = zoom / 1.1) {
            if (!isSectorOne) {
                try {
                    one = new Mandlebrot(mandle, y, y + zoom, x - zoom, x, halfHeight, halfWidth);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //one.clear(0, 0);
                isSectorOne = true;
            }
        }
    }

    public void sectorTwo(double zoom) throws InterruptedException {
        for(; zoom>6.7e-13; zoom=zoom/1.1) {
            if(!isSectorTwo) {
                try {
                    two = new Mandlebrot(mandle, y, y + zoom, x, x + zoom, halfHeight, halfWidth);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //two.clear(250, 0);
                isSectorTwo = true;
            }
        }
    }

    public void sectorThree(double zoom) throws InterruptedException {
        for(; zoom>6.7e-13; zoom=zoom/1.1) {
            if (!isSectorThree) {
                try {
                    three = new Mandlebrot(mandle, y - zoom, y, x - zoom, x, halfHeight, halfWidth);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //three.clear(0, 250);
                isSectorThree = true;
            }
        }
    }

    public void sectorFour(double zoom) throws InterruptedException {
        for(; zoom>6.7e-13; zoom=zoom/1.1) {
            if (!isSectorFour) {
                try {
                    four = new Mandlebrot(mandle, y - zoom, y, x, x + zoom, halfHeight, halfWidth);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //three.clear(250, 250);
                isSectorFour = true;
            }
        }
    }

    @Override
    public void run(){
        System.out.println("I am running lol");
    }
}
