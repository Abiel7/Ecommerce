class Config {
  SCHEME = process.env.SCHEME ? process.env.SCHEME : "http";
  HOST = process.env.HOST ? process.env.HOST : "localhost";
  PORT = process.env.PORT ? process.env.PORT : "8080";
  //urls
  LOGIN_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/auth/token`;
  PRODUCT_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/products`;
  CART_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/carts`;
  ORDER_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/orders`;
  CUSTOMER_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/customers`;
  ADDRESS_URL = `${this.SCHEME}://${this.HOST}:${this.PORT}/api/v1/addresses`;

  ACCESS_TOKEN = "accessToken";
  EXPIRATION = "expiration";

  /*
      returns headers that are being used in all api calls
    */
  headers() {
    return {
      "Content-type": "application/json",
      Accepts: "application/json",
    };
  }
  /**
   * return common headers with auth header ,
   * the auth header is fetched from the localstorage
   *  which is set when a user is logged in.
   * @returns
   */

  headersWithAuth() {
    return {
      ...this.headers(),
      Authorization: localStorage.getItem(this.ACCESS_TOKEN),
    };
  }

  /**
   * check the expiration time for a token stored in localstorage
   *
   */
  tokenExpired() {
    const expDAte = Number(localStorage.getItem(this.ACCESS_TOKEN));
    if (expDAte > Date.now) {
      return true;
    }
    return false;
  }

  /**
   * store a given token  with its expiration date to the localstorage
   */
  storeToken(token) {
    localStorage.setItem(this.ACCESS_TOKEN, `Bearer${token}`);
    localStorage.setItem(this.EXPIRATION, this.getExpiration(token));
  }

  /**
   *  extract the expiration time from a given token.
   */
  getExpiration(token) {
    let encodedPayload = token ? token.split(".")[1] : null;
    console.log(encodedPayload);
    if (!encodedPayload) return 0;
    encodedPayload = encodedPayload.replace(/-/g, "+").replace(/_/g, "/");
    const payload = JSON.parse(window.atob(encodedPayload));
    return payload?.exp ? payload?.exp * 1000 : 0;
  }
}

export default Config;
