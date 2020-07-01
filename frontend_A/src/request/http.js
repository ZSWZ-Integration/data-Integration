import axios from 'axios'

//axios.defaults.baseURL = "http://116.62.123.74:8080";
//axios.defaults.baseURL = "http://101.201.150.49:8080";
axios.defaults.baseURL = "http://localhost:8081";

/**
  * get方法，对应get请求
  * @param {String} url [请求的url地址]
  * @param {Object} params [请求时携带的参数]
  */
export function get(url, params){
    return new Promise((resolve, reject) =>{
        axios.get(url, {
            params: params
        })
        .then(res => {
            resolve(res);
            ////console.log(res);
        })
        .catch(err => {
            reject(err)
        })
    });
}

/**
  * post方法，对应post请求
  * @param {String} url [请求的url地址]
  * @param {Object} params [请求时携带的参数]
  */
export function post(url, params) {
    return new Promise((resolve, reject) => {
        axios.post(url, params)
        .then(res => {
            resolve(res);
        })
        .catch(err => {
            //console.log(err);

            reject(err)
        })
    });
}

/**
 * delete请求
 * @param {String} url 
 * @param {Object} params 
 */
export function del(url) {
    return new Promise((resolve, reject) => {
        axios.delete(url, {	
            
          }).then(res => {
            resolve(res);
        })
        .catch(err => {
            reject(err)
        })
    }

    );
}

/**
 * 
 * @param {String} url 
 * @param {Object} params 
 */
export function put(url, params) {
    return new Promise((resolve, reject) => {
        axios.put(url, params)
        .then(res => {
            resolve(res);
        })
        .catch(err => {
            ////console.log(err);
            reject(err)
        })
    });
}