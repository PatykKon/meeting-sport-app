import {SportFieldInterface} from "./sport-field.interface";

export interface EventCartInterface{

  title: string;
  description: string;
  startTime: string;
  endTime: string;
  gameTime: number;
  maxPlayers:number;
  age:number;
  sportFieldResponse: SportFieldInterface;


}
