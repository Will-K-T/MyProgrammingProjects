/// <reference path="./Libraries/p5Intellisense/p5.global-mode.d.ts" />

class Particle {
  constructor() {
    this.pos = createVector(random() * width, random() * height);
    this.vel = createVector(0, 0);
    this.acc = createVector(0, 0);
    this.size = particleSize;
    this.col = color(0, 0, 0, 255);
    this.maxSpeed = 1;
    console.log(particleSize);
  }

  closestVector() {
    let x = (round(this.pos.x / sq) + cols) % cols;
    let y = (round(this.pos.y / sq) + rows) % rows;
    return vectors[x][y];
  }

  update() {
    this.vel.add(this.acc);
    this.vel.limit(this.maxSpeed);
    this.pos.add(this.vel);
    this.acc.mult(0);

    this.pos.x = (this.pos.x + width) % width;
    this.pos.y = (this.pos.y + height) % height;
  }

  addForce(force) {
    this.acc.add(force);
  }

  display() {
    fill(this.col);
    noStroke();
    circle(this.pos.x, this.pos.y, this.size);
  }
}
