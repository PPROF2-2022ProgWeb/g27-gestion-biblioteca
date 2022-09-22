export interface IUser {
  id: number;
  name: string;
  lastName: string;
  address: string;
  phone: string;
  email: string;
  password: string;
  sanctions: number;
  sanctionsAmount: number;
}

export interface IPublicUserInfo {
  avatar: string | undefined;
  name: string;
  id: number;
}
