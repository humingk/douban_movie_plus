import axios from 'axios'
import MockAdapter from 'axios-mock-adapter'

import {LoginUsers, users} from './data/user'

export default {

    init() {
        let mock = new MockAdapter(axios)
        // mock success request
        mock.onGet('/success').reply(200, {
            msg: 'success'
        })

        // mock error request
        mock.onGet('/error').reply(500, {
            msg: 'failure'
        })

        // 登录
        mock.onPost('/login').reply(arg => {
            let {useremail, password} = JSON.parse(arg.data)
            return new Promise((resolve, reject) => {
                let token = null


                let hasUser = LoginUsers.some(u => {
                    if (u.email === username && u.password === password) {
                        token = 'adminXXXXXX'
                        return true
                    }
                })

                if (hasUser) {
                    resolve([200, {code: 200, msg: '请求成功', token: token}])
                } else {
                    resolve([200, {code: 500, msg: '账号或密码错误'}])
                }

            })
        })


    }

}
