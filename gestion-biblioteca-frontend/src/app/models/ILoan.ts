import { IUser } from './IUser';
import { IBook } from './IBook';
export interface ILoan {
    id: number;
    dateOut: string,
    dateReturn: string;
    book: IBook;
    user: IUser;
}
