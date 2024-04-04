import { Injectable } from '@angular/core';

const USER ="user";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  static saveUser(user: any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  static getUser() {
    return JSON.parse(localStorage.getItem(USER) || '{}'); // Asserting it as string or an empty object if null
  }

  static getUserRole(): string {
    const user = StorageService.getUser();
    return user.role || ""; // If role is null or undefined, return empty string
  }

  static getUserId(): string {
    const user = StorageService.getUser();
    return user.id || ""; // If id is null or undefined, return empty string
  }

  static isAdminLoggedIn(): boolean {
    const role: string = StorageService.getUserRole();
    return role === "ADMIN";
  }

  static isCustomerLoggedIn(): boolean {
    const role: string = StorageService.getUserRole();
    return role === "CUSTOMER";
  }

  static logout(): void {
    window.localStorage.removeItem(USER);
  } 

}
