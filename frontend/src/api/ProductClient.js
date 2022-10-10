import Config from "./config";
class ProductClient {
  constructor() {
    this.config = new Config();
  }
  async fetchAllProducts() {
    return fetch(this.config.PRODUCT_URL, {
      method: "GET",
      mode: "cors",
      headers: {
        ...this.config.headers(),
      },
    })
      .then((response) => Promise.all([response, response.json()]))
      .then(([response, json]) => {
        if (!response.ok) {
          return { success: false, error: json };
        }
        return { success: true, data: json };
      })
      .catch((e) => {
        console.log(e);
      });
  }
  async fetchProductByID(prodId) {
    return fetch(this.config.PRODUCT_URL + "/" + `${prodId}`, {
      method: "GET",
      mode: "cors",
      headers: {
        ...this.config.headers(),
      },
    })
      .then((response) => Promise.all([response, response.json()]))
      .then(([resposne, json]) => {
        console.log(resposne);
        if (!resposne.ok) {
          return { success: false, error: json };
        }

        return { success: false, data: json };
      })
      .catch((e) => {
        console.log(e);
      });
  }
}
