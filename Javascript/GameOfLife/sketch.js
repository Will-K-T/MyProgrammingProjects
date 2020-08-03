/// <reference path="./Libraries/p5Intellisense/p5.global-mode.d.ts" />

var nodes = [];

let squareSize = 4;

let w = 0; let h = 0;

function preload(){
  w = 400;
  h = 400;
  
  for(let i=0; i<h/squareSize; i++){
    nodes[i] = [];
   for(let j=0; j<w/squareSize; j++){
     nodes[i].push(Math.trunc(random(0,1)*2));
   }
  }
}

function setup() {
  createCanvas(w, h);
  
  background(0);
  
  frameRate(10)
}

function draw() {
  
  drawNodes(nodes, color(62, 146, 204));
  
  updateNodes(nodes);

}

function updateNodes(n){
  let copy = [];
  for(let i=0; i<h/squareSize; i++){
    copy[i] = [];
  }
  for(let i=0; i<h/squareSize; i++){
   for(let j=0; j<w/squareSize; j++){
     let alive = findNeighborsAlive(n, i, j);
     if(nodes[i][j] == 1){
       if(alive == 2 || alive == 3){
        copy[i][j] = 1;
       }
       else{
        copy[i][j] = 0; 
       }
     }
     else if(nodes[i][j] == 0 && alive == 3){
       copy[i][j] = 1; 
     }
     else{
       copy[i][j] = 0; 
     }
   }
  }
  nodes = copy;
}

function drawNodes(n, col) {
  noStroke();
  
  for(let i=0; i<h/squareSize; i++){
   for(let j=0; j<w/squareSize; j++){
     if(nodes[i][j] == 1){
       fill(col);
       rect(j*squareSize, i*squareSize, squareSize, squareSize);
     }
     else{
       fill(0);
       rect(j*squareSize, i*squareSize, squareSize, squareSize);
     }
   }
  }
}

function findNeighborsAlive(n, row, col){
    let count = 0;
    for(let i = -1; i <= 1; i++){
     for(let j = -1; j <= 1; j++){
       let cr = (((row+i)+h/squareSize)%(h/squareSize));
       let cc = (((col+j)+h/squareSize)%(h/squareSize));
       if( !(i == 0 && j == 0) && n[cr][cc] == 1){
         count++;
       }
     }
    }
    return count;
}