int sensorVal;
int sensorLow = 1023;
int sensorHigh = 0;

const int ledPin = 13;
const int C = 262;
const int D = 293;
const int E = 330;
const int G = 393;

void setup() {
  // put your setup code here, to run once:
//  pinMode(ledPin, OUTPUT);
//  digitalWrite(ledPin, HIGH);
//  while(millis() < 5000){
//    sensorVal = analogRead(A0);
//    if(sensorVal > sensorHigh){
//      sensorHigh = sensorVal;
//    }
//    if(sensorVal < sensorLow){
//      sensorLow = sensorVal;
//    }
//  }
//  digitalWrite(ledPin, LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  //sensorVal = analogRead(A0);
  //int pitch = map(sensorVal, sensorLow, sensorHigh, 50, 2000);
  //tone(8, pitch, 20);

  tone(8, E, 500);
   delay(500);
  tone(8, D, 500);
   delay(500);
  tone(8, C, 500);
   delay(500);
  tone(8, D, 500);

   delay(500);
  tone(8, E, 500);
   delay(500);
  tone(8, E, 500);
   delay(500);
  tone(8, E, 500);
   delay(1000);

  tone(8, D, 500);
   delay(500);
  tone(8, D, 500);
   delay(500);
  tone(8, D, 500);
   delay(1000);

  tone(8, E, 500);
   delay(500);
  tone(8, G, 500);
   delay(500);
  tone(8, G, 500);
   delay(1000);

  tone(8, E, 500);
   delay(500);
  tone(8, D, 500);
   delay(500);
  tone(8, C, 500);
   delay(500);
  tone(8, D, 500);

   delay(500);
  tone(8, E, 500);
   delay(500);
  tone(8, E, 500);
   delay(500);
  tone(8, E, 500);
   delay(1000);

  tone(8, D, 500);
   delay(500);
  tone(8, D, 500);
   delay(500);
  tone(8, E, 1000);
   delay(1000);
  tone(8, D, 1000);
   delay(1000);
  tone(8, C, 2000);
   delay(2000);
}
