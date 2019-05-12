<template>
  <div id="subject" v-if="movieBase.movieId">
    <div id="wrapper">
      <div id="content">
        <h1>
          <span style="color: #f7097a;">{{movieBase.name}}</span>
          <span style="color: #f7097a;" v-if="movieApi.original_title"> {{movieApi.original_title|isEnglish()}}</span>
          <span  class="year" v-if="movieApi.year">({{movieApi.year}})</span>
          <span v-if="!movieApi.id" style="font-size: 16px">(资料不全,查看更多请<a
            :href="url_douban+'/subject/'+movieBase.movieId" target="_blank">点击此处</a>去豆瓣电影)</span>
        </h1>
        <div class="grid-16-8 clearfix">
          <div class="article">
            <div class="indent clearfix">
              <div class="subjectwrap clearfix">
                <div class="subject clearfix">
                  <div id="mainpic" class="" v-if="movieApi.images">
                    <a class="nbgnbg" v-if="movieApi.images" :href="movieApi.images.large"><img
                      :src="movieApi.images.large" rel="noreferrer"></a>
                    <p class="gact"></p>
                  </div>
                  <div class="info">
                    <span class="pl" v-if="movieBase.directors.length">导演: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.directors"><a
                      target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.directors.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.writers.length">编剧: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.writers"><a target="_blank"
                                                                                     :href="'/celebrity/'+item.actorId">{{item.name}}</a>{{ index === movieBase.writers.length-1 ? "" : " / " }}</span><br>
                    <span id="actorInfo">
                      <div style="width: 34px;float: left;">
                    <span class="pl" v-if="movieBase.leadingactors.length">演员: </span>
                      </div>
                      <div style="overflow:hidden">
                    <span class="attrs" v-for="(item,index) in movieBase.leadingactors" v-if="index < 6">
                      <a target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>
                      {{ index === movieBase.leadingactors.length-1 ? "" : " / " }}
                    </span>
                      <span class="attrs" v-for="(item,index) in movieBase.leadingactors"
                            v-if="index >= 10 && !brandOrFold">
                      <a target="_blank" :href="'/celebrity/'+item.actorId">{{item.name}}</a>
                      {{ index === movieBase.leadingactors.length-1 ? "" : " / " }}
                    </span>
                      <span @click="moreActor()" v-if="movieBase.leadingactors.length>10"
                            style="color: #8c169b;font-size: 11px">
                       <i style="font-size: 13px">{{brandOrFold?'...(展开)':'(收起)'}}</i>
                      </span>
                      <br>
                      </div>
                    </span>
                    <span class="pl" v-if="movieBase.types.length">类型: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.types"><a target="_blank"
                                                                                   :href="'/tag/'+item.typeName">{{item.typeName}}</a>{{ index === movieBase.types.length-1 ? "" : " / " }}</span><br>
                    <span class="tagsInfo">
                      <div style="width: 34px;float: left;">
                    <span class="pl" v-if="movieBase.tags.length">标签: </span>
                      </div>
                      <div style="overflow:hidden">
                    <span class="attrs" v-for="(item,index) in movieBase.tags"><a target="_blank"
                                                                                  :href="'/tag/'+item.tagName">{{item.tagName}}</a>{{ index === movieBase.tags.length-1 ? "" : " / " }}</span><br>
                      </div>
                    </span>
                    <span v-if="imdbApi && imdbApi.Runtime">
                    <span class="pl">时长: </span>
                    <span class="attrs">{{imdbApi.Runtime}}</span><br>
                    </span>
                    <span v-if="imdbApi && imdbApi.Country">
                    <span class="pl">地区: </span>
                    <span class="attrs">{{imdbApi.Country}}</span><br>
                    </span>
                    <span class="pl" v-if="movieBase.types.length">上映时间: </span>
                    <span class="attrs" v-for="(item,index) in movieBase.releasetimes">{{item.timeArea}}{{ index === movieBase.releasetimes.length-1 ? "" : " / " }}</span><br>
                    <span class="pl" v-if="movieBase.movieId">豆瓣电影: </span>
                    <span class="attrs"><a target="_blank"
                                           :href="url_douban+'/subject/'+movieBase.movieId">{{movieBase.movieId}}</a></span><br>
                    <span v-if="movieBase.imdbId || imdbApi.imdbID">
                    <span class="pl">IMDB: </span>
                    <span class="attrs" v-if="movieBase.imdbId"><a target="_blank"
                                                                   :href="url_imdb+'/title/'+movieBase.imdbId">{{movieBase.imdbId}}</a></span>
                      <span class="attrs" v-if="!movieBase.imdbId && imdbApi.imdbID"><a target="_blank"
                                                                                        :href="url_imdb+'/title/'+imdbApi.imdbID">{{imdbApi.imdbID}}</a></span>
                    </span>
                  </div>
                </div>
                <div id="interest_sectl">
                  <!--豆瓣评分-->
                  <div class="rating_wrap clearbox">
                    <div class="clearfix">
                      <div class="rating_logo ll">
                        <a :href="url_douban" target="_blank">
                          豆瓣电影
                        </a>
                      </div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix">
                      <strong class="ll rating_num">{{movieBase.rate==0?'囧':movieBase.rate}}</strong>
                      <span content="10.0"></span>
                      <div class="rating_right ">
                        <div :class="'ll bigstar '+getBigRateType(movieBase.rate)"></div>
                        <div class="rating_sum">
                          <div class="rating_people"><span>
                            <a :href="url_douban+'/subject/'+movieBase.movieId+'/collections'" target="_blank"
                               v-if="movieApi.id">
                            {{movieApi.rating.average==0?'仅':''}}{{movieApi.ratings_count|thousands()}}人评价
                            </a>
                          </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--IMDB评分-->
                  <div v-if="imdbApi.imdbID" class="rating_wrap clearbox">
                    <div class="clearfix">
                      <div class="rating_logo ll">
                        <a :href="url_imdb" target="_blank">
                          IMDB
                        </a>
                      </div>
                      <div class="output-btn-wrap rr" style="">
                      </div>
                    </div>
                    <div class="rating_self clearfix">
                      <strong class="ll rating_num">{{imdbApi.imdbRating=='N/A'?'囧':imdbApi.imdbRating}}</strong>
                      <span content="10.0"></span>
                      <div class="rating_right ">
                        <div :class="'ll bigstar '+getBigRateTypeForImdb(imdbApi.imdbRating)"></div>
                        <div class="rating_sum">
                          <div class="rating_people">
                            <span>
                            <a target="_blank" :href="url_imdb+'/title/'+movieBase.imdbId">
                              {{imdbApi.imdbVotes=='N/A'?'暂时无':imdbApi.imdbVotes}}人评价
                            </a>
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--Metacritic-->
                  <div v-if="imdbApi.Ratings && imdbApi.Ratings.length>1">
                    <div v-if="item.Source=='Rotten Tomatoes'" class="rating_wrap clearbox"
                         v-for="item in imdbApi.Ratings">
                      <div class="clearfix">
                        <div class="rating_logo ll">
                          <a :href="url_metacritic" target="_blank">
                            MTC
                          </a>
                        </div>
                        <div class="output-btn-wrap rr" style="">
                        </div>
                      </div>
                      <div class="rating_self clearfix">
                        <strong class="ll rating_num" v-if="item.Value!='20%'">{{item.Value|fixSlish()}}</strong>
                        <strong class="ll rating_num" v-if="item.Value=='20%'">囧</strong>
                        <span content="10.0"></span>
                        <div class="rating_right ">
                          <div :class="'ll bigstar '+getBigRateTypeForMetacritic(item.Value)"></div>
                          <div class="rating_sum">
                            <div class="rating_people" v-if="movieApi.original_title">
                              <a target="_blank"
                                 :href="url_metacritic+'/movie/'+getMetacriticName(movieApi.original_title)">
                                Metacritic -->
                              </a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div v-if="item.Source=='Metacritic'" class="rating_wrap clearbox" v-for="item in imdbApi.Ratings">
                      <div class="clearfix">
                        <div class="rating_logo ll">
                          <a :href="url_tomato" target="_blank">
                            烂番茄
                          </a>
                        </div>
                        <div class="output-btn-wrap rr" style="">
                        </div>
                      </div>
                      <div class="rating_self clearfix">
                        <strong class="ll rating_num">{{item.Value|fixPercent()}}</strong>
                        <span content="10.0"></span>
                        <div class="rating_right ">
                          <div :class="'ll bigstar '+getBigRateTypeForTomatoes(item.Value)"></div>
                          <div class="rating_sum" v-if="movieApi.original_title">
                            <a target="_blank" :href="url_tomato+'/m/'+getTomatoName(movieApi.original_title)">
                              RTomatoes -->
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="related-info">
              <a name="intro"></a>
              <h2>
                <i class="">剧情简介......</i>
              </h2>
              <div class="indent" id="link-report">
                        <span class="summary" v-if="movieApi.summary">
                        {{movieApi.summary}}
                       </span>
              </div>
            </div>
            <div id="celebrities" class="celebrities related-celebrities">
              <h2>
                <i class>演职员列表......</i>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/celebrities'"
                                    target="_blank">
                  (共计{{movieBase.directors.length+movieBase.writers.length + movieBase.leadingactors.length}}人)</a></span>
              </h2>
              <ul class="celebrities-list from-subject __oneline">
                <li class="celebrity" v-for="item in movieApi.directors">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="item in movieApi.writers">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
                <li class="celebrity" v-for="(item,index) in movieApi.casts" v-if="index < 3">
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="avatar">
                      <img :src="item.avatars.large" v-if="item.avatars" rel="noreferrer">
                    </div>
                  </a>
                  <a :href="'/celebrity/'+item.id" target="_blank" class="">
                    <div class="info">
                      <span class="name">{{item.name}}</span>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
            <div id="related-pic" class="related-pic">
              <h2>
                <i class>图片列表......</i>
                <span class="pl"><a :href="'/subject/'+movieBase.movieId+'/all_photos'"
                                    target="_blank">(共计{{movieApi.photos_count?movieApi.photos_count:"..."}}张)</a></span>
              </h2>
              <ul class="related-pic-bd wide_videos">
                <li v-for="(item,index) in movieApi.photos">
                  <a :href="item.alt" target="_blank">
                    <img :src="item.cover | getSmallPhoto" alt="图片" rel="noreferrer" style="padding: 8px;box-sizing: border-box">
                  </a>
                </li>
              </ul>
            </div>
            <div id="comments-section">
              <div class="mod-hd">
                <h2>
                  <i class>热门短评......</i>
                  <span class="pl">
                  <a :href="url_douban+'/subject/'+movieBase.movieId+'/comments'"
                     target="_blank">(共计{{movieApi.comments_count?movieApi.comments_count:"..."}}条)</a>
                </span>
                </h2>
              </div>
              <div class="mod-bd">
                <div class="tab-bd">
                  <div id="hot-comments" class="tab">
                    <div class="comment-item" v-for=" (item,index) in movieApi.popular_comments" v-if="index < 5">
                      <div class="comment">
                        <h3>
                            <span class="comment-vote">
                              <span class="votes">{{item.useful_count}} 有用</span>
                            </span>
                          <span class="comment-info">
                            <a :href="url_douban+'/people/'+item.author.id" target="_blank" class="">{{item.author.name}}</a>
                            <span :class="getRateType(item.rating.value)+' rating'"></span>
                            <span class="comment-time">{{item.created_at}}</span>
                          </span>
                        </h3>
                        <p class="">
                          <span class="short">{{item.content}}</span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <section class="reviews mod movie-content">
              <header>
                <h2>
                  <i class>热门影评......</i>
                  <span class="pl">
                                    <a :href="url_douban+'/subject/'+movieBase.movieId+'/reviews'" target="_blank">
                    (共计{{movieApi.reviews_count?movieApi.reviews_count:"..."}}条)
                                    </a>
                  </span>
                </h2>
              </header>
              <div class="review-list">
                <div v-for="(item,index) in movieApi.popular_reviews" v-if="index < 5" class="main review-item">
                  <header class="main-hd">
                    <a :href="url_douban+'/people/'+item.author.id" class="avator">
                      <img width="24" height="24" :src="item.author.avatar">
                    </a>
                    <a :href="url_douban+'/people/'+item.author.id" class="name"
                       target="_blank">{{item.author.name}}</a>
                    <span :class="getRateType(item.rating.value)+' main-title-rating'"></span>
                    <!--影评时间-->
                    <span class="main-meta"></span>
                  </header>
                  <div class="main-bd">
                    <h2>
                      <a :href="item.alt" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.title}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </h2>
                    <div class="review-short">
                      {{item.summary}}
                    </div>
                  </div>
                </div>
              </div>
            </section>
            <!--网易云音乐-->
            <div id="all-songs" v-for="item in neteaseSongs" v-if="item.data.hotComments.length !== 0">
              <div id="songs-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐单曲 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/song?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a></i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="song-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfSong,index) in item.data.hotComments" v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfSong.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfSong.user.userId" target="_blank" class=""> {{itemOfSong.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfSong.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfSong.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="all-albums" v-for="item in neteaseAlbums" v-if="item.data.hotComments.length !== 0">
              <div id="albums-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐专辑 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/album?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a>
                    </i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="album-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfAlbum,index) in item.data.hotComments" v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfAlbum.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfAlbum.user.userId" target="_blank" class=""> {{itemOfAlbum.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfAlbum.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfAlbum.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="all-playlists" v-for="item in neteasePlaylists" v-if="item.data.hotComments.length !== 0">
              <div id="playlists-section">
                <div class="mod-hd">
                  <h2>
                    <i class>网易云音乐歌单 <span style="color:#79078f">< {{item.name}} ></span> 热门评论......<a
                      :href="url_netease+'/playlist?id='+item.id"
                      target="_blank"><i style="font-size:13px;">查看更多</i></a></i>
                    <span class="pl">
                </span>
                  </h2>
                </div>
                <div class="mod-bd">
                  <div class="tab-bd">
                    <div id="playlist-hot-comments" class="tab">
                      <div class="comment-item" v-for=" (itemOfPlaylist,index) in item.data.hotComments"
                           v-if="index < 5">
                        <div class="comment">
                          <h3>
                            <span class="comment-vote">
                              <span class="votes">{{itemOfPlaylist.likedCount}} 喜欢</span>
                            </span>
                            <span class="comment-info">
                              <a :href="url_netease+'/user/home?id='+itemOfPlaylist.user.userId" target="_blank"
                                 class=""> {{itemOfPlaylist.user.nickname}} </a>
                            <span class="comment-time" style="font-size: 11px;"> &nbsp;&nbsp; 创建于 {{itemOfPlaylist.time | formatDate()}}</span>
                          </span>
                          </h3>
                          <p class="">
                            <span class="short">{{itemOfPlaylist.content}}</span>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!--书籍评论-->
            <div id="book-comments-section"
                 v-if="bookComments && bookComments.comments && bookComments.comments.length!=0">
              <div class="mod-hd">
                <h2>
                  <i class>原著相关 <span style="color:#79078f"><a
                    :href="url_douban_book+'/subject/'+bookComments.bookId"
                    target="_blank">< {{bookComments.bookName}} ></a></span> 热门短评......</i>
                  <span class="pl">
                  <a :href="url_douban_book+'/subject/'+bookComments.bookId+'/comments'"
                     target="_blank">(共计{{bookComments.total?bookComments.total:"..."}}条)</a>
                </span>
                </h2>
              </div>
              <div class="mod-bd">
                <div class="tab-bd">
                  <div id="book-hot-comments" class="tab">
                    <div class="comment-item" v-for=" (item,index) in bookComments.comments" v-if="index < 5">
                      <div class="comment">
                        <h3>
                            <span class="comment-vote">
                              <span class="votes">{{item.votes}} 有用</span>
                            </span>
                          <span class="comment-info">
                            <a :href="url_douban_book+'/people/'+item.author.id" target="_blank" class="">{{item.author.name}}</a>
                            <span v-if="item.rating && item.rating.value"
                                  :class="getRateType(item.rating.value)+' rating'"></span>
                            <span class="comment-time">{{item.published}}</span>
                          </span>
                        </h3>
                        <p class="">
                          <span class="short">{{item.summary}}</span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="book-reviews-section" v-if="bookReviews && bookReviews.reviews && bookReviews.reviews.length!=0">
              <section class="reviews mod movie-content">
                <header>
                  <h2>
                    <i class>原著相关 <span style="color:#79078f"><a
                      :href="url_douban_book+'/subject/'+bookReviews.bookId"
                      target="_blank">< {{bookReviews.bookName}} ></a></span> 热门书评......</i>
                    <span class="pl">
                                    <a :href="url_douban+'/subject/'+movieBase.movieId+'/reviews'" target="_blank">
                    (共计{{bookReviews.total?bookReviews.total:"..."}}条)
                                    </a>
                  </span>
                  </h2>
                </header>
                <div class="review-list">
                  <div v-for="(item,index) in bookReviews.reviews"
                       v-if="index < 5 && item.summary && item.summary.toString().charAt(0)!='{'"
                       class="main review-item">
                    <header class="main-hd">
                      <a :href="url_douban_book+'/people/'+item.author.id" class="avator">
                        <img width="24" height="24" :src="item.author.avatar">
                      </a>
                      <a :href="url_douban_book+'/people/'+item.author.id" class="name"
                         target="_blank">{{item.author.name}}</a>
                      <span v-if="item.rating && item.rating.value"
                            :class="getRateType(item.rating.value)+' main-title-rating'"></span>
                      <!--影评时间-->
                      <span class="main-meta">
                      <span class="comment-time">{{item.updated}}</span>
                    </span>
                    </header>
                    <div class="main-bd">
                      <h2>
                        <a :href="item.alt" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.title}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                      </h2>
                      <div class="review-short">
                        {{item.summary}}
                      </div>
                    </div>
                  </div>
                </div>
              </section>
            </div>
            <br>
          </div>
          <div class="aside" style="position: absolute; margin-left: 690px;">
            <!--mp3-->
            <div id="musicAbout" v-if="isMusicAllOk && neteaseMusic && neteaseMusic.length!=0 "
                 style="margin-bottom: 20px">
              <h2>
                <i>配乐 / 相关 <a style="color:#79078f" :href="url_netease+'/#/search/m/?s='+neteaseSearchKeyword"
                              target="_blank">< {{neteaseSearchKeyword}} > </a></i>
              </h2>
              <aplayer
                :music="neteaseMusic[0]"
                :list="neteaseMusic"
                :showLrc="showLrc"
                repeat="repeat-all"
              >
              </aplayer>
            </div>
            <div id="musicPlaylist" v-if="isMusicAllOk && neteasePlaylistSongs && neteasePlaylistSongs.length!=0 "
                 style="margin-bottom: 20px">
              <h2>
                <i>歌单 / 相关 <a style="color:#79078f" :href="url_netease+'/#/playlist?id='+neteasePlaylistSongsId"
                              target="_blank">< {{neteasePlaylistSongsName}} > </a></i>
              </h2>
              <aplayer
                autoplay
                :music="neteasePlaylistSongs[0]"
                :list="neteasePlaylistSongs"
                :showLrc="showLrc"
                :repeat="'repeat-all'"
              >
              </aplayer>
            </div>
            <div id="musicAlbum" v-if="isMusicAllOk && neteaseAlbumSongs && neteaseAlbumSongs.length!=0"
                 style="margin-bottom: 20px">
              <h2>
                <i>专辑 / 相关 <a style="color:#79078f" :href="url_netease+'/#/album?id='+neteaseAlbumSongsId"
                              target="_blank">< {{neteaseAlbumSongsName}} > </a></i>
              </h2>
              <aplayer
                :music="neteaseAlbumSongs[0]"
                :list="neteaseAlbumSongs"
                :showLrc="showLrc"
                :repeat="'repeat-all'"
              >
              </aplayer>
            </div>
            <!--原著信息-->
            <div :id="'book_'+index" v-if="bookSearch.books && bookSearch.count!=0"
                 style="margin-top: 10px;margin-bottom: 20px;"
                 v-for="(book,index) in bookSearch.books">
              <h2>
                <i class="">原著 / 相关 <a style="color:#79078f" :href="book.alt" target="_blank">< {{book.title}}
                  > </a><span
                  v-if="book.rating && book.rating.average && book.rating.average!='0.0'" style="color: #f7097a">{{book.rating.average}}</span></i>
              </h2>
              <div
                style="box-shadow: 2px 3px 6px 0 rgba(0,0,0,0.2);transition: 0.3s;width: 100%;border-radius: 3px;min-height: 120px;margin-left: 5px;">
                <div class="mainpicforbook">
                  <a class="nbgnbg" :href="book.alt">
                    <img
                      :src="book.images.large" rel="noreferrer" style="max-height: 95px"></a>
                  <p class="gact"></p>
                </div>
                <div style="line-height: 16px;">
                <span v-if="book.origin_title">
                <span class="pl">原名: </span>
                <span class="attrs">{{book.origin_title}}</span><br>
                </span>
                  <span v-if="book.author && book.author.length!=0">
                <span class="pl">作者: </span>
                <span class="attrs" v-for="(item,index) in book.author">{{item}}{{ index === book.author.length-1 ? "" : " / " }}</span><br>
                </span>
                  <span v-if="book.translator && book.translator.length!=0">
                <span class="pl">译者: </span>
                <span class="attrs" v-for="(item,index) in book.translator">{{item}}{{ index === book.translator.length-1 ? "" : " / " }}</span><br>
                </span>
                  <span v-if="book.publisher">
                <span class="pl">出版社: </span>
                <span class="attrs">{{book.publisher}}</span><br>
                </span>
                  <span v-if="book.pages">
                <span class="pl">页数: </span>
                <span class="attrs">{{book.pages}}</span><br>
                </span>
                  <span v-if="book.isbn13">
                <span class="pl">ISBN: </span>
                <span class="attrs">{{book.isbn13}}</span><br>
                </span>
                </div>
              </div>
            </div>

            <div id="mit"
                 v-show="(btbtdyResource && btbtdyResource.length!=0) || (loldyttResource && loldyttResource.length!=0)"
                 style="margin-top: 10px;margin-bottom: 20px;">
              <h2>
                <i class="" style="color:#f7097a">严正声明 </i>
              </h2>
              <div
                style="box-shadow: 2px 3px 6px 0 rgba(0,0,0,0.2);transition: 0.3s;width: 100%;border-radius: 3px;min-height: 120px;margin-left: 5px;">
                <span style="font-size: 13px">
                本站为开源项目,遵守<b style="color: red">MIT</b>开源协议!<br>
                本站以下链接均为<b style="color:red">友情链接</b>,解释权非本站所有!<br>

                友情链接原则:<br>
                  &nbsp;&nbsp;1. 仅供学习交流,不做任何商业用途.<br>
                  &nbsp;&nbsp;2. 仅收录经典冷门影视作品.<br>
                  &nbsp;&nbsp;3. 拒绝收录近期上映的电影!<br>

                若发现任何上述违规现象,请<a :href="'mailto:'+url_email+'?subject='+movieBase.name+'('+movieBase.movieId+')侵犯版权'">联系站长</a>.将立即删除!<br>
                </span>
              </div>
            </div>

            <!--btbtdy 资源信息-->
            <div :id="'btbtby_'+index" v-show="btbtdyResource && btbtdyResource.length!=0"
                 style="margin-top: 10px;margin-bottom: 20px;"
                 v-for="(res,index) in btbtdyResource">
              <h2>
                <i class="">友情链接 <span style="color:#79078f">< {{res.movieName}} > </span></i>
              </h2>
              <div
                style="box-shadow: 3px 5px 10px 0 rgba(192,192,192,0.2);transition: 0.3s;width: 100%;border-radius: 3px;margin-left: 5px;">
                <div v-show="res.p720 && res.p720.length!=0">
                  <h3 class="resourceTitle"><i>720P</i>
                  </h3>
                  <div v-for="(item,index) in res.p720" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
                <div v-show="res.p1080 && res.p1080.length!=0">
                  <h3 class="resourceTitle"><i>1080P</i>
                  </h3>
                  <div v-for="(item,index) in res.p1080" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
                <div v-show="res.k4 && res.k4.length!=0">
                  <h3 class="resourceTitle"><i>4K</i>
                  </h3>
                  <div v-for="(item,index) in res.k4" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
                <div v-show="res.ed2k && res.ed2k.length!=0">
                  <h3 class="resourceTitle"><i>ED2K</i>
                  </h3>
                  <div v-for="(item,index) in res.ed2k" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
                <div v-show="res.blue && res.blue.length!=0">
                  <h3 class="resourceTitle"><i>BluRay</i>
                  </h3>
                  <div v-for="(item,index) in res.blue" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
              </div>
            </div>
            <!--loldytt 资源信息-->
            <div :id="'loldytt_'+index" v-show="loldyttResource && loldyttResource.length!=0"
                 style="margin-top: 10px;margin-bottom: 20px;"
                 v-for="(res,index) in loldyttResource">
              <h2>
                <i class="">友情链接<span style="color:#79078f">< {{res.movieName}} ></span>
                </i>
              </h2>
              <div
                style="box-shadow: 3px 5px 10px 0 rgba(192,192,192,0.2);transition: 0.3s;width: 100%;border-radius: 3px;margin-left: 5px;">
                <div v-show="res.thunder && res.thunder.length!=0">
                  <h3 class="resourceTitle"><i>迅雷链接</i>
                  </h3>
                  <div v-for="(item,index) in res.thunder" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px;max-width: 350px;word-wrap: break-word">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
                <div v-show="res.magnet && res.magnet.length!=0">
                  <h3 class="resourceTitle"><i>磁力链接</i>
                  </h3>
                  <div v-for="(item,index) in res.magnet" class="resourceNext">
                  <span>
                  <a :href="item.resourceUrl" style="font-size: 13px ;max-width: 350px;word-wrap: break-word">{{item.resourceName}}</a><br>
                </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import axios from 'axios'
  import {
    url_ssm_base, url_netease, url_imdb, url_douban, url_douban_book, url_metacritic, url_tomato,
    url_email, url_btbtdy, url_loldytt, url_api_netease, url_omdb, apikey_omdb, url_api_douban, apikey_api_douban,
  } from '../config';
  // MP3播放器
  import Aplayer from '../../node_modules/vue-aplayer';
  // 禁用aplayer版本输出
  Aplayer.disableVersionBadge = true;
  export default {
    name: 'subject',
    data: function () {
      return {
        url_imdb: url_imdb,
        url_douban: url_douban,
        url_douban_book: url_douban_book,
        url_netease: url_netease,
        url_metacritic: url_metacritic,
        url_tomato: url_tomato,
        url_btbtdy: url_btbtdy,
        url_loldytt: url_loldytt,
        url_email: url_email,
        // 网易云音乐评论最大展示数
        numOfSongs: 2,
        numOfAlbums: 2,
        numOfPlaylists: 2,
        // 书籍最大展示数
        numOfBooks: 2,
        // 演员的展开与收起
        brandOrFold: true,
        subTitle: " +1s",
        bookSearch: {},
        bookComments: {},
        bookReviews: {},
        neteaseSearch: {},
        // netease成功获取的标志
        flagForNetease: false,
        // music 计数器
        musicOk: 0,
        // music 准备
        isMusicAllOk: false,
        neteaseMusic: [],
        // netease search 关键字
        neteaseSearchKeyword: "",
        // 是否显示歌词
        showLrc: true,
        neteasePlaylistSongs: [],
        // 此歌单ID
        neteasePlaylistSongsId: '',
        // 此歌单name
        neteasePlaylistSongsName: '',
        // 歌单歌曲播放列表最大数
        numOfPlaylistSongs: 10,
        neteaseAlbumSongs: [],
        // 专辑ID
        neteaseAlbumSongsId: '',
        // 专辑name
        neteaseAlbumSongsName: '',
        // 专辑歌曲播放列表最大数
        numOfAlbumSongs: 10,
        neteaseSongs: [],
        neteaseAlbums: [],
        neteasePlaylists: [],
        // Btbtdy资源
        btbtdyResource: [],
        // Loldytt资源
        loldyttResource: [],
        // imdb 获取成功标志
        flagForImdb: false,
        imdbApi: {
          imdbId: "",
          Ratings: []
        },
        movieApi: {},
        movieBase: {
          movieId: "",
          name: "",
          rate: "",
          alias: "",
          imdbId: "",
          directors: [],
          writers: [],
          leadingactors: [],
          types: [],
          tags: [],
          releasetimes: []
        }
      }
    },
    components: {
      Aplayer
    },
    props: {},
    created: function () {
      // 获取 movie API
      this.getMovieApi(this.$route.params.movieId);
    },
    methods: {
      // axios 方法集合---------------------start

      // 从豆瓣电影API获取电影信息
      getMovieApi: function (movieId) {
        // params集合会导致获取信息不全,采用url拼接
        this.$jsonp(url_api_douban + "/v2/movie/subject/" + movieId + "?apikey=" + apikey_api_douban).then(responseApi => {
          if (responseApi.id) {
            console.log("movie douban API :");
            console.log(responseApi);
            this.movieApi = responseApi;
            /**
             * 获取 movie base
             * 获取 IMDB
             * 获取 netease songs albums playlists comments
             * 获取 douban book comments reviews
             * 更新 rate
             * 更新 movie base
             *
             */
            // 第一级axios流程
            // param2==null ： 更新base
            this.getMovieBase(movieId, responseApi);
          }
          // 获取movie API 失败
          else {
            // 第二级axios流程
            // param2!=null ： 不更新base
            this.getMovieBase(movieId, null);
            console.log("get movie api fail....(server error)")
          }
        }).catch(error => {
          console.log("during get movie douban api fail...");
          console.log(error);
        });
      },
      // 从服务器获取电影基础信息
      getMovieBase: function (movieId, responseApi) {
        axios.get(url_ssm_base + "/subject/" + movieId).then(responseBase => {
          // 服务端有这部电影
          if (responseBase.data && responseBase.data.code && responseBase.data.message) {
            if (responseBase.data.code == 200 && responseBase.data.message == "success") {
              console.log("movie base :");
              console.log(responseBase);
              this.movieBase = responseBase.data.data;
              // 设置标题
              document.title = responseBase.data.data.name + this.subTitle;
              // 更新服务端 评分 (服务器没有此电影时候,更新base包括rate)
              this.updateRate(responseApi.id, responseApi.rating.average);
              // 获取 imdb 相关
              // 豆瓣API没有imdbID...所以仅此情况可以获取
              // if (this.movieBase.imdbId && this.movieBase.imdbId != '') {
              //   this.getImdb(this.movieBase.imdbId);
              // } else {
              //   console.log("sorry there is no imdbID from base...");
              // }
            }
            // 服务端没有这部电影
            else if (responseBase.data.message == "fail") {
              console.log("get moviebase failed...(server error)");
              // 需要更新base
              if (responseApi) {
                console.log("there is no movie base...");
                // 更新服务器 base
                this.updateMovieBase(responseApi);
                // 设置标题
                document.title = responseApi.title + this.subTitle;
              }
            }
          } else {
            console.log("get moviebase failed...(connect error)");
          }

          // 获取电影资源信息
          if (this.movieBase.name) {
            this.getBtbtdyResource(this.movieBase.name);
            this.getLoldyttResource(this.movieBase.name);
          } else if (responseApi.title) {
            this.getBtbtdyResource(responseApi.title);
            this.getLoldyttResource(responseApi.title);
          } else {
            console.log("there is no name to get movie resource...")
          }

          // IMDB 搜索关键字
          let keywordsForImdb = [];
          keywordsForImdb.push(responseApi.original_title ? responseApi.original_title : "");
          if (responseApi.aka && responseApi.aka.length != 0) {
            for (let i = 0; i < responseApi.aka.length; i++) {
              // 仅英语情况下才有用
              if (this.isEnglishForKeyword(responseApi.aka[i])) {
                keywordsForImdb.push(responseApi.aka[i]);
              }
            }
          }
          if (this.movieBase.imdbId && this.movieBase.imdbId != '') {
            // 通过imdb ID 获取 IMDB信息
            this.getImdbById(this.movieBase.imdbId);
          }
          // base没有imdbId
          else {
            // 通过imdb keyword year 获取 IMDB信息
            this.getImdbByKeyword(keywordsForImdb, responseApi.year ? responseApi.year : null, 0);
          }
          // 获取网易云音乐 通过 moviebase 电影搜索相关
          // this.getNetease(this.movieBase.name);
          let keywordsForNetease = [];
          keywordsForNetease.push(this.fixSearchKeyword(this.movieBase.name));
          keywordsForNetease.push(responseApi.original_title ? responseApi.original_title : null);
          if (responseApi.aka && responseApi.aka.length != 0) {
            for (let i = 0; i < responseApi.aka.length; i++) {
              keywordsForNetease.push(responseApi.aka[i])
            }
          }
          this.getNetease(keywordsForNetease, 0);
          // 获取豆瓣图书信息 start count
          this.getBookSearch(this.movieBase.name, 0, this.numOfBooks);
        }).catch(error => {
          console.log("during get movie base failed...(client fail)");
          console.log(error);
        });
      },

      // movie base 上传到服务器
      updateMovieBase: function (responseApi) {
        // 先赋值base
        this.copyBase(responseApi);
        // 更新
        axios.post(url_ssm_base + "/subject/addMovieAll", this.movieBase).then(
          response => {
            if (response.data && response.data.code && response.data.message) {
              if (response.data.code == 200 && response.data.message == "success") {
                console.log("update movie base success...");
                console.log(this.movieBase);
              } else if (response.data.message == "fail") {
                console.log("update movie base fail...(server fail)");
              }
            } else {
              console.log("update movie base fail...(connect fail)");
            }
          }).catch(error => {
          console.log("update movie base fail...(client fail)");
          console.log(error);
        });
      },
      // api的值给base
      copyBase: function (responseApi) {
        this.movieBase.movieId = responseApi.id;
        this.movieBase.name = responseApi.title;
        if (responseApi.rating) {
          this.movieBase.rate = responseApi.rating.average;
        }
        if (responseApi.aka && responseApi.aka != '') {
          this.movieBase.alias = responseApi.aka.toString().replace(/,/g, "/");
        }
        if (responseApi.directors) {
          for (let i = 0; i < responseApi.directors.length; i++) {
            this.movieBase.directors.push({
              "actorId": responseApi.directors[i].id,
              "name": responseApi.directors[i].name
            });
          }
        }
        if (responseApi.writers) {
          for (let i = 0; i < responseApi.writers.length; i++) {
            this.movieBase.writers.push({
              "actorId": responseApi.writers[i].id,
              "name": responseApi.writers[i].name
            });
          }
        }
        if (responseApi.casts) {
          for (let i = 0; i < responseApi.casts.length; i++) {
            this.movieBase.leadingactors.push({
              "actorId": responseApi.casts[i].id,
              "name": responseApi.casts[i].name
            });
          }
        }
        if (responseApi.pubdates) {
          for (let i = 0; i < responseApi.pubdates.length; i++) {
            this.movieBase.releasetimes.push({timeArea: responseApi.pubdates[i]});
          }
        }
        if (responseApi.genres) {
          for (let i = 0; i < responseApi.genres.length; i++) {
            this.movieBase.types.push({typeName: responseApi.genres[i]});
          }
        }
        if (responseApi.tags) {
          for (let i = 0; i < responseApi.tags.length; i++) {
            this.movieBase.tags.push({"tagName": responseApi.tags[i]});
          }
        }
      },
      // rate 上传至服务器
      updateRate: function (movieId, rate) {
        axios.get(url_ssm_base + "/subject/updateRate", {
          params: {
            movieId: movieId,
            rate: rate
          }
        }).then(response => {
          if (response.data && response.data.code && response.data.message) {
            if (response.data.code == 200 && response.data.message == "success") {
              console.log("update movie rate success...");
            } else if (response.data.message == "fail") {
              console.log("update movie rate fail...(service error)");
            }
          } else {
            console.log("update movie rate fail...(connect error)");
          }
        }).catch(error => {
          console.log("update movie rate fail...");
          console.log(error);
        });
      },
      // 豆瓣书籍搜索信息
      getBookSearch: function (keyword, start, count) {
        keyword = this.fixSearchKeyword(keyword);
        console.log("douban book search keyword: " + keyword + " (success)");
        this.$jsonp(url_api_douban + "/v2/book/search?q=" + keyword + "&start=" + start + "&count=" + count + "&apikey=" + apikey_api_douban).then(response => {
          if (response.count && response.count != 0) {
            console.log("douban book search:");
            console.log(response);
            this.bookSearch = response;
            // 获取原著短评
            this.getBookComments(this.bookSearch.books[0].id, this.bookSearch.books[0].title, 0, 5);
            // 获取原著影评
            this.getBookReviews(this.bookSearch.books[0].id, this.bookSearch.books[0].title, 0, 5);
          } else {
            console.log("douban book search keyword: " + keyword + " (fail)");
          }
        }).catch(error => {
          console.log("get douban book search fail...");
          console.log(error);
        });
      },
      // 获取原著短评信息
      getBookComments: function (bookId, bookName, start, count) {
        this.$jsonp(url_api_douban + "/v2/book/" + bookId + "/comments?start=" + start + "&count=" + count + "&apikey=" + apikey_api_douban).then(response => {
          if (response.count && response.count != 0) {
            console.log("douban book comments:");
            console.log(response);
            this.bookComments = response;
            this.bookComments.bookId = bookId;
            this.bookComments.bookName = bookName;
          } else {
            console.log("get douban book comments fail...(server error)");
          }
        }).catch(error => {
          console.log("get douban book comments fail...");
          console.log(error);
        });
      },
      // 获取原著长评信息
      getBookReviews: function (bookId, bookName, start, count) {
        this.$jsonp(url_api_douban + "/v2/book/" + bookId + "/reviews?start=" + start + "&count=" + count + "&apikey=" + apikey_api_douban).then(response => {
          if (response.count && response.count != 0) {
            console.log("douban book reviews:");
            console.log(response);
            this.bookReviews = response;
            this.bookReviews.bookId = bookId;
            this.bookReviews.bookName = bookName;
          } else {
            console.log("get douban book reviews fail...(server error)");
          }
        }).catch(error => {
          console.log("get douban book reviews fail...");
          console.log(error);
        });
      },
      // 获取网易云音乐 电影搜索相关 由于需要循环异步axios,此处采用递归代替循环
      getNetease: function (keywords, now) {
        // 不能超出keywords 仍未成功获取netease
        if (now < keywords.length && !this.flagForNetease) {
          axios.get(url_api_netease + "/search/suggest?keywords=" + keywords[now]).then(result => {
            if (result.data) {
              this.neteaseSearch = result.data;
              if (result.data.result && result.data.result.order && result.data.result.order.length != 0) {
                // 获取成功标志
                this.flagForNetease = true;
                // 搜索关键字
                this.neteaseSearchKeyword = keywords[now];
                console.log("netease movie search:");
                console.log(result);
                console.log("netease search keywords: " + keywords[now] + "(success)");
                // 获取网易云音乐 歌曲评论 歌曲播放信息列表
                if (result.data.result.songs) {
                  let songs = result.data.result.songs;
                  // music加载计数器
                  this.musicOk += songs.length;
                  for (let i = 0; i < songs.length; i++) {
                    // 限制获取评论对应歌曲个数
                    if (i < this.numOfSongs) {
                      this.getNeteaseSongs(songs[i].id, songs[i].name);
                    }
                    // 歌曲 封面 -> 歌词
                    this.getNeteaseSongPic(songs[i].id, songs[i].name, songs[i].artists ? songs[i].artists[0].name : null, 0);
                  }
                  console.log("netease songs comments:");
                  console.log(this.neteaseSongs);
                }
                // 获取网易云音乐 专辑评论
                if (result.data.result.albums) {
                  let albums = result.data.result.albums;
                  //获取第一个专辑的所有歌曲播放信息
                  if (albums.length && albums.length != 0) {
                    this.neteaseAlbumSongsId = albums[0].id;
                    this.neteaseAlbumSongsName = albums[0].name;
                    this.getNeteaseAlbumSongs(albums[0].id);
                  }
                  for (let i = 0; i < albums.length && i < this.numOfAlbums; i++) {
                    this.getNeteaseAlbums(albums[i].id, albums[i].name);
                  }
                  console.log("netease albums comments:");
                  console.log(this.neteaseAlbums);
                }
                // 获取网易云音乐 歌单评论
                if (result.data.result.playlists) {
                  let playlists = result.data.result.playlists;
                  //获取第一个歌单的所有歌曲播放信息
                  if (playlists.length && playlists.length != 0) {
                    this.neteasePlaylistSongsId = playlists[0].id;
                    this.neteasePlaylistSongsName = playlists[0].name;
                    this.getNeteasePlaylistSongs(playlists[0].id);
                  }
                  for (let i = 0; i < playlists.length && i < this.numOfPlaylists; i++) {
                    this.getNeteasePlaylists(playlists[i].id, playlists[i].name);
                  }
                  console.log("netease playlist comments:");
                  console.log(this.neteasePlaylists);
                }
              }
              // 获取失败,继续递归调用下一个
              else {
                console.log("netease search keywords: " + keywords[now] + "(fail)");
                this.getNetease(keywords, ++now);
              }
            } else {
              console.log("during get netease search failed...(server error)");
            }
          }).catch(error => {
            console.log("during get netease search failed...");
            console.log(error);
          });
        }

      },

      // 获取网易云歌曲 封面
      getNeteaseSongPic: function (song_id, songName, artistName, type) {
        axios.get(url_api_netease + "/song/detail?ids=" + song_id).then(resultMusic => {
          // console.log("detail");
          // console.log(resultMusic);
          if (resultMusic.data) {
            // 歌词
            this.getNeteaseMusic(song_id, songName, artistName, type,
              (resultMusic.data.songs && resultMusic.data.songs.length != 0 && resultMusic.data.songs[0].al &&
                resultMusic.data.songs[0].al.picUrl) ? resultMusic.data.songs[0].al.picUrl : null
            );
          } else {
            console.log("get netease music pic " + song_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease music-" + song_id + " 's music pic failed:");
          console.log(error);
        });
      },

      // 获取网易云音乐 歌单歌曲
      getNeteasePlaylistSongs: function (playlist_id) {
        axios.get(url_api_netease + "/playlist/detail?id=" + playlist_id).then(resultSongs => {
          console.log("the first playlist songs: ");
          console.log(resultSongs);
          if (resultSongs.data && resultSongs.data.playlist && resultSongs.data.playlist.tracks) {
            // music加载计数器
            this.musicOk += Math.min(resultSongs.data.playlist.tracks.length, this.numOfPlaylistSongs);
            for (let i = 0; i < resultSongs.data.playlist.tracks.length && i < this.numOfPlaylistSongs; i++) {
              this.getNeteaseMusic(
                resultSongs.data.playlist.tracks[i].id,
                resultSongs.data.playlist.tracks[i].name ? resultSongs.data.playlist.tracks[i].name : "Untitled",
                resultSongs.data.playlist.tracks[i].ar ? resultSongs.data.playlist.tracks[i].ar[0].name : "Unknown",
                1,
                (resultSongs.data.playlist.tracks[i].al && resultSongs.data.playlist.tracks[i].al.picUrl) ? resultSongs.data.playlist.tracks[i].al.picUrl : null
              );
            }
          } else {
            console.log("get netease playlist " + playlist_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease playlist-" + playlist_id + " 's songs failed:");
          console.log(error);
        });
      },

      // 获取专辑歌曲
      getNeteaseAlbumSongs: function (album_id) {
        axios.get(url_api_netease + "/album?id=" + album_id).then(resultSongs => {
          console.log("the first album songs: ");
          console.log(resultSongs);
          if (resultSongs.data && resultSongs.data.songs && resultSongs.data.songs.length != 0) {
            // music加载计数器
            this.musicOk += Math.min(resultSongs.data.songs.length, this.numOfAlbumSongs);
            for (let i = 0; i < resultSongs.data.songs.length && i < this.numOfAlbumSongs; i++) {
              this.getNeteaseMusic(
                resultSongs.data.songs[i].id,
                resultSongs.data.songs[i].name ? resultSongs.data.songs[i].name : "Untitled",
                resultSongs.data.songs[i].ar ? resultSongs.data.songs[i].ar[0].name : "Unknown",
                2,
                (resultSongs.data.songs[i].al && resultSongs.data.songs[i].al.picUrl) ? resultSongs.data.songs[i].al.picUrl : null
              );
            }
          } else {
            console.log("get netease album " + album_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease album-" + album_id + " 's songs failed:");
          console.log(error);
        });
      },

      // 获取网易云音乐  ==> 播放信息(获取歌词影响加载速度)
      getNeteaseMusic: function (song_id, songName, artistName, type, picUrl) {
        (type == 0 ? this.neteaseMusic : (type == 1 ? this.neteasePlaylistSongs : this.neteaseAlbumSongs)).push({
          title: songName,
          artist: artistName,
          src: url_netease + "/song/media/outer/url?id=" + song_id + ".mp3",
          pic: picUrl ? picUrl : "",
        });
        // music加载计数器复原
        this.musicOk--;
        // 是否是加载最后一个music
        if (this.musicOk == 0) {
          this.isMusicAllOk = true;
        }
      },

      // 获取网易云音乐 歌曲评论
      getNeteaseSongs: function (song_id, name) {
        axios.get(url_api_netease + "/comment/music?id=" + song_id).then(resultSongs => {
          if (resultSongs.data) {
            this.neteaseSongs.push({
              id: song_id,
              name: name,
              data: resultSongs.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease song " + song_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease song-" + song_id + " 's comments failed:");
          console.log(error);
        });
      },
      // 获取网易云音乐 专辑评论
      getNeteaseAlbums: function (album_id, name) {
        axios.get(url_api_netease + "/comment/album?id=" + album_id).then(resultAlbums => {
          if (resultAlbums.data) {
            this.neteaseAlbums.push({
              id: album_id,
              name: name,
              data: resultAlbums.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease album " + album_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease album-" + album_id + " 's comments failed:");
          console.log(error);
        });
      },
      // 获取网易云音乐 歌单评论
      getNeteasePlaylists: function (playlist_id, name) {
        axios.get(url_api_netease + "/comment/playlist?id=" + playlist_id).then(resultPlaylists => {
          if (resultPlaylists.data) {
            this.neteasePlaylists.push({
              id: playlist_id,
              name: name,
              data: resultPlaylists.data
            });
            // console success 在 netease search 方法
          } else {
            console.log("get netease playlist " + playlist_id + " failed...(server error)");
          }
        }).catch(error => {
          console.log("get netease playlist-" + playlist_id + " 's comments failed:");
          console.log(error);
        });
      }
      ,

      // 获取IMDB信息 通过imdb ID
      getImdbById: function (imdbId) {
        axios.get(url_omdb + "/", {
          params: {
            apikey: apikey_omdb,
            plot: 'full',
            i: imdbId
          }
        }).then(response => {
          if (response.data && response.data.Title) {
            this.imdbApi = response.data;
            console.log("imdb Api by imdbId :");
            console.log(response.data);
          } else {
            console.log("get imdb api by imdbId fail...(server fail)");
          }
        }).catch(error => {
          console.log("get imdb api by imdbId fail...");
          console.log(error);
        });
      },

      // 获取IMDB信息 通过keyword year 因为循环调用异步axios,故此处采用递归代替循环
      getImdbByKeyword: function (keywords, year, now) {
        // 还未获取IMDB 且 不超出keywords
        if (!this.flagForImdb && now < keywords.length) {
          axios.get(url_omdb + "/", {
            params: {
              apikey: apikey_omdb,
              plot: 'full',
              t: keywords[now],
              y: year
            }
          }).then(response => {
            if (response.data && response.data.imdbID) {
              // 获取成功标志
              this.flagForImdb = true;
              console.log("imdbApi search keyword: " + keywords[now] + " (success)");
              this.imdbApi = response.data;
              console.log("imdb Api by title :");
              console.log(response.data);
              // 更新服务器的imdbId
              this.updateImdbId(this.$route.params.movieId, response.data.imdbID ? response.data.imdbID : null);
            }
            // 获取失败,再次递归调用
            else {
              console.log("imdbApi search keyword: " + keywords[now] + " (fail)");
              this.getImdbByKeyword(keywords, year, ++now);
            }
          }).catch(error => {
            console.log("get imdb api by title fail...");
            console.log(error);
          });
        }
      },

      // 更新服务器的imdbId
      updateImdbId: function (movieId, imdbId) {
        if (imdbId) {
          axios.get(url_ssm_base + "/subject/updateImdbId", {
            params: {
              movieId: movieId,
              imdbId: imdbId
            }
          }).then(response => {
            if (response.data && response.data.code && response.data.message) {
              if (response.data.code == 200 && response.data.message == "success") {
                console.log("update movie imdbId success...");
              } else if (response.data.message == "fail") {
                console.log("update movie imdbId fail...(service error)");
              }
            } else {
              console.log("update movie imdbId fail...(connect error)");
            }
          }).catch(error => {
            console.log("update movie imdbId fail...");
            console.log(error);
          });
        }
      },

      // 获取Btbtdy电影资源信息
      getBtbtdyResource: function (keyword) {
        axios.get(url_ssm_base + "/subject/getBtbtdyResource", {
          params: {
            keyword: keyword
          }
        }).then(response => {
          if (response.data && response.data.code && response.data.message) {
            if (response.data.code == 200 && response.data.message == "success") {
              console.log("movie btbtdy resource:");
              console.log(response.data);
              this.btbtdyResource = response.data.data;
            } else if (response.data.message == "fail") {
              console.log("get movie btbtdy resource fail...(service error)");
            }
          } else {
            console.log("get movie btbtdy resource fail...(connect error)");
          }
        }).catch(error => {
          console.log("get movie btbtdy resource fail...");
          console.log(error);
        });
      },

      // 获取Loldytt电影资源信息
      getLoldyttResource: function (keyword) {
        axios.get(url_ssm_base + "/subject/getLoldyttResource", {
          params: {
            keyword: keyword
          }
        }).then(response => {
          if (response.data && response.data.code && response.data.message) {
            if (response.data.code == 200 && response.data.message == "success") {
              console.log("movie resource:");
              console.log(response.data);
              this.loldyttResource = response.data.data;
            } else if (response.data.message == "fail") {
              console.log("get movie loldytt resource fail...(service error)");
            }
          } else {
            console.log("get movie loldytt resource fail...(connect error)");
          }
        }).catch(error => {
          console.log("get movie loldytt resource fail...");
          console.log(error);
        });
      },

      // axios 方法集合---------------------end
      // 判断是否展开更多actors
      moreActor: function () {
        if (this.brandOrFold) {
          this.brandOrFold = false;
        } else {
          this.brandOrFold = true;
        }
      },
      // 返回 豆瓣电影 小星星
      getRateType: function (rate) {
        switch (parseInt(rate)) {
          case 1:
            return 'allstar10';
            break;
          case 2:
            return 'allstar20';
            break;
          case 3:
            return 'allstar30';
            break;
          case 4:
            return 'allstar40';
            break;
          case 5:
            return 'allstar50';
            break;
          default:
            return '';
        }
      }
      ,
      // 返回 豆瓣电影 大星星
      getBigRateType: function (rate) {
        if (rate <= 10 && rate > 9) {
          return 'bigstar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigstar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigstar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigstar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigstar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigstar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigstar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigstar10';
        } else {
          return 'bigstar5';
        }
      }
      ,
      // 返回 烂番茄 星星
      getBigRateTypeForTomatoes: function (rateT) {
        let rate = parseFloat(rateT.toString().replace(/%/g, '')) / 10;
        if (rate <= 10 && rate > 9) {
          return 'bigTomato45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigTomato40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigTomato35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigTomato30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigTomato25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigTomato20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigTomato15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigTomato10';
        } else {
          return 'bigTomato5';
        }
      }
      ,
      // 返回 Imdb 星星
      getBigRateTypeForImdb: function (rate) {
        if (rate <= 10 && rate > 9) {
          return 'bigImdbStar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigImdbStar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigImdbStar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigImdbStar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigImdbStar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigImdbStar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigImdbStar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigImdbStar10';
        } else {
          return 'bigImdbStar5';
        }
      }
      ,
      // 返回 metacritic 星星
      getBigRateTypeForMetacritic: function (rateM) {
        let rate = parseFloat(rateM.toString().replace(/\/100/g, '')) / 10;
        if (rate <= 10 && rate > 9) {
          return 'bigMetacriticStar45';
        } else if (rate <= 9 && rate > 8) {
          return 'bigMetacriticStar40';
        } else if (rate <= 8 && rate > 7) {
          return 'bigMetacriticStar35';
        } else if (rate <= 7 && rate > 6) {
          return 'bigMetacriticStar30';
        } else if (rate <= 6 && rate > 5) {
          return 'bigMetacriticStar25';
        } else if (rate <= 5 && rate > 4) {
          return 'bigMetacriticStar20';
        } else if (rate <= 4 && rate > 3) {
          return 'bigMetacriticStar15';
        } else if (rate <= 3 && rate > 2) {
          return 'bigMetacriticStar10';
        } else {
          return 'bigMetacriticStar5';
        }
      },
      // 搜索关键字精简(网易云搜索,豆瓣读书搜索)
      fixSearchKeyword: function (val) {
        // 中文冒号 英文冒号 空格
        let keyword = val.toString().split(/[：|:|\s]/)[0];
        return keyword;
      },

      // 判断 origin_name 是不是英文名，中文名就不要重复了
      isEnglishForKeyword: function (val) {
        let first = val.toString().charAt(0);
        if ((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z')) {
          return true;
        } else {
          return false;
        }
      },
      // 获取 metacritic 对应的电影名
      getMetacriticName: function (val) {
        return val.toString().replace(/ |: /g, '-').toLowerCase();
      },
      // 获取 rottentomato 对应的电影名
      getTomatoName: function (val) {
        return val.toString().replace(/ |: /g, '_').toLowerCase();
      },
    }
    ,
    filters: {
      // 判断 origin_name 是不是英文名，中文名就不要重复了
      isEnglish: function (val) {
        let first = val.toString().charAt(0);
        return ((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z')) ? val.toString() : "";
      }
      ,
      // 网易云音乐 Unix时间戳 转换
      formatDate: function (value) {
        if (!value) return '';
        let date = new Date(value);
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        return year + '-' + month + '-' + day + ' ' + hour + ':' + minute;
      }
      ,
      // 豆瓣评价人数千分位转换
      thousands: function (val) {
        return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
      }
      ,
      // 烂番茄去除百分号并且两个数之间加小数点
      fixPercent: function (val) {
        return parseFloat(val.toString().replace(/%/g, '')) / 10;
      }
      ,
      // Metacritic 去除斜杠
      fixSlish: function (val) {
        return parseFloat(val.toString().replace(/\/100/g, '')) / 10;
      },
      
      // 获取更小的图片链接 sqs => sqxs
      getSmallPhoto:function (val) {
        return val.toString().replace(/sqs/g,'sqxs');
      }
    },
    // 渲染页面之后
    mounted: function () {
    }
  }
</script>
<style>
  @import "../../static/douban/css/subject.css";
</style>
