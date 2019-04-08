import axios from 'axios'

axios.defaults.baseURL = 'localhost:8080'

export const requestLogin = params => {
    return axios.post(
        '/loginForm',
        params
    ).then(
        res => res.data
    )
}
