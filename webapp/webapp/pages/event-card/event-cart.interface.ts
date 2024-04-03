import {SportFieldInterface} from "./sport-field.interface";
import {EventRoleInterface} from "./event-role.interface";

export interface EventCartInterface{
  id: number
  title: string;
  description: string;
  startTime: string;
  endTime: string;
  gameTime: number;
  maxPlayers:number;
  age: number;
  sportFieldResponse: SportFieldInterface;
  eventRoleResponse: EventRoleInterface;


}
