/// <reference path="./Libraries/p5Intellisense/p5.global-mode.d.ts" />

let sq = 10;

let weight = 10;

let cols, rows;
let fr;

let particleSize;
let oppacity;

let changeXOff;
let changeYOff;
let changeZOff;

let vectors;

let particles;

let slider;
let oppSlider;
let sizeSlider;
let prevSliderVal;

let numOfParticles = 1000;

let inc = .01;

function setup() {
  createCanvas(400, 400);
  background(255, 255, 255);

  cols = floor(width / sq);
  rows = floor(height / sq);

  fr = createP('');

  changeXOff = random();
  changeYOff = random();
  changeZOff = random();

  slider = createSlider(0, .004, .001, .0001);
  prevSliderVal = slider.value();

  oppSlider = createSlider(0, 255, 5, 1);
  sizeSlider = createSlider(1, 100, 5, 1);
  particleSize = sizeSlider.value();

  particles = [];
  for(let i=0; i<numOfParticles; i++){
    particles[i] = new Particle();
  }

  vectors = [];
  for(let i=0; i<rows; i++){
    vectors[i] = [];
  }

  noStroke();
}

function draw(){
  // background(255, 255, 255);

  // noiseOneD(changeXOff);

  // noiseTwoD(changeXOff, changeYOff);

  // noiseThreeD(changeXOff, changeYOff, changeZOff);

  // noNoiseRandom();

  flowField(changeXOff, changeYOff);

  changeXOff += slider.value();
  changeYOff += slider.value();
  changeZOff += slider.value();

  fr.html(floor(frameRate()));
  if(slider.value() != prevSliderVal){
    prevSliderVal = slider.value();
    background(255, 255, 255);
  }

  oppacity = oppSlider.value();
  particleSize = sizeSlider.value();

  // noLoop();
}

function flowField(startXOff, startYOff){
  let yOff = startYOff;
  stroke(0, 0, 0, 100);
  for(let i=0; i<rows; i++){
    let xOff = startXOff;
    for(let j=0; j<cols; j++){
      let ang = noise(xOff, yOff)*TWO_PI*2;
      vectors[i][j] = p5.Vector.fromAngle(ang);
      vectors[i][j].setMag(weight);
      let v = vectors[i][j];
      // push();
      // translate(i*sq, j*sq);
      // rotate(v.heading());
      // line(0, 0, sq, 0);
      // pop();
      xOff += inc;
    }
    yOff += inc;
  }

  for(let i=0; i<particles.length; i++){
    let dir = particles[i].closestVector();
    particles[i].update();
    particles[i].display();
    particles[i].addForce(dir);
  }

  // let yOff = 0;
  // for (let y=0; y<rows; y++){
  //   let xOff = 0;
  //   for(let x=0; x<cols; x++){
  //     let ang = noise(xOff, yOff)*TWO_PI;
  //     let v = p5.Vector.fromAngle(ang);
  //     stroke(255);
  //     push();
  //     translate(x*scl, y*scl);
  //     rotate(v.heading());
  //     line(0, 0, scl, 0);
  //     pop();
  //     xOff += inc;
  //   }
  //   yOff += inc;
  // }
}

function noiseThreeD(startXOff, startYOff, startZOff){
  let xOff = startXOff;
  let yOff = startYOff;
  let zOff = startZOff; // idk yet lol

  for(let i=0; i<height/sq; i++){
    for(let j=0; j<width/sq; j++){
      fill(noise(xOff, yOff, zOff)*255);
      rect(j*sq, i*sq, sq, sq);
      
      xOff += inc;
    }
    yOff += inc;
  }
}

function noiseTwoD(startXOff, startYOff){
  fill(0, 0, 0);
  let yOff = startYOff;

  for(let i=0; i<height/sq; i++){
    let xOff = startXOff;
    for(let j=0; j<width/sq; j++){
      fill(noise(xOff, yOff)*255);
      rect(j*sq, i*sq, sq, sq);
      xOff += inc;
    }
    yOff += inc;
  }
}

function noiseOneD(startXOff){
  noFill();
  stroke(255);
  let xOff = startXOff;
  beginShape();
  for(let i=0; i<width; i++){
    vertex(i, noise(xOff)*height);

    xOff += inc;
  }
  endShape();
}

function noNoiseRandom(){
  noFill();
  stroke(255);
  beginShape();
  for(let i=0; i<width; i++){
    vertex(i, random(height));
  }
  endShape();
}