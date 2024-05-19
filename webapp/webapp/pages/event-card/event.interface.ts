import {SportFieldInterface} from "./sport-field.interface";
import {EventRoleInterface} from "./event-role.interface";

export interface EventInterface {
  id: number
  title: string
  description: string
  players: number
  minAge: number
  startTime: string
  endTime: string
  gameTime: number
  ownerId: number
  sportFieldResponse: SportFieldInterface
  eventRoleResponse: EventRoleInterface[];

}
