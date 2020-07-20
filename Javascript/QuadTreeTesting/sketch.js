function setup() {
  createCanvas(400, 400);

  let boundary = new Rectangle(200, 200, 200, 200);

  let qtree = new QuadTree(boundary, 4);

  console.log(qtree);

  for(let i=0; i<500; i++){
    let p = new Point(random(400), random(400));
    qtree.insert(p);
  }
  background(0);
  qtree.show();

  stroke(0, 255, 0);
  rectMode(CENTER);
  let range = new Rectangle(random(width), random(height), 100, 100);
  rect(range.x, range.y, range.w*2, range.h*2);
  let points = qtree.query(range);
  for(let p of points){
    strokeWeight(4);
    point(p.x, p.y);
  }
}
