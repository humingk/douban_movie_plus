// vue的url
let url_vue_base = "https://movie.doubans.com";
// ssm的url
let url_ssm_base = "https://movie.doubans.com:8082";
// neteaseMusic base url
let url_netease = "https://music.163.com";
// IMDB
let url_imdb= "https://www.imdb.com";
// 豆瓣
let url_douban= "https://movie.douban.com";
// 豆瓣读书
let url_douban_book="https://book.douban.com";
// metacritic
let url_metacritic= "https://www.metacritic.com";
// tomato
let url_tomato= "https://www.rottentomatoes.com";
// BT电影天堂
let url_btbtdy="http://www.btbtdy.me";
// LOL电影天堂
let url_loldytt="http://www.loldytt.tv";
// 站长邮箱
let url_email="humingk@qq.com";
//---------API

// neteaseMusic 第三方api url
// neteaseThirdApi 会通过nginx转发到本地的3000
let url_api_netease = "https://movie.doubans.com/neteaseThirdApi";

// IMDB OMDB api url
// omdbApi 通过 nginx 转发到 www.omdbapi.com
// let url_omdb = "http://www.omdbapi.com";
let url_omdb = "https://movie.doubans.com/omdbApi";
// apikey=
let apikey_omdb = "e409ce71";

// 吉卜力工作室 API
let url_gbl = "https://ghibliapi.herokuapp.com";
// 时光网 API url
let url_time = "https://api-m.mtime.cn";

// 豆瓣V2 API url apiKey
let url_api_douban = "https://api.douban.com";
// apikey=
let apikey_api_douban = "0b2bdeda43b5688921839c8ecb20399b";
// 豆瓣V2 API url apikey 备用
let url_api_douban_bak = "https://douban.uieee.com";
// apukey=
let apikey_api_douban_bak = "0df993c66c0c636e29ecbb5344252a4a";

export {
  url_vue_base,
  url_ssm_base,
  url_netease,
  url_imdb,
  url_douban,
  url_douban_book,
  url_metacritic,
  url_tomato,
  url_btbtdy,
  url_loldytt,
  url_email,
  url_api_netease,
  url_omdb,
  apikey_omdb,
  url_gbl,
  url_time,
  url_api_douban,
  apikey_api_douban,
  url_api_douban_bak,
  apikey_api_douban_bak
}
