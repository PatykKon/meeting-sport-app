import {SportFieldInterface} from "./sport-field.interface";

export interface EventInterface{
  id: number
  title:string
  description:string
  players:number
  minAge:number
  startTime:string
  endTime:string
  gameTime:number
  sportField: SportFieldInterface
}
