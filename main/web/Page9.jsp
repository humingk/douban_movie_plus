<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 赵柯存  v_1.0  完成于2018.10.01 -->
<html>
<head>
<style>
@import
url(db.css)
</style>
</head>
<body>
	<div class="navigate" id="db-navigate">
		<div class="wrap">
			<div class="primary">
				<div class="navigate-logo">
					<img src="image/logo.jpg" width="120" height="70" />
				</div>
				<div class="search-textfeild">
					<form action="null">
						<input type="text" name="search"> <input type="submit"
							value="搜索">
					</form>
				</div>

			</div>
			<div class="navigate-title">
				<ul class="nav">
					<li><a href="null">影讯&购票</a></li>
					<li><a href="null">选电影</a></li>
					<li><a href="null">电视剧</a></li>
					<li><a href="null">排行榜</a></li>
					<li><a href="null">分类</a></li>
					<li><a href="null">影评</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="specific-movie">
		<div class="movie-title">
			<span property="movie_name_cast">碟中谍6：全面瓦解的全部演员职员</span>
		</div>
		<div class="director">
			<div class="director_title">导演 Director</div>
			<br> <img src="image/mi_director.jpg" width="120" height="150">
			<li><span class="movie_director_name"><a href="null">克里斯托弗·麦奎尔</a></span></li>
			<li><span class="movie_director_product">代表作：明日边缘/碟中谍5/碟中谍6</span></li>
		</div>
		<div class="cast">
			<span class="cast_title">演员 Cast</span>
			<br>
			<div>
				<img src="image/tomcruse.jpg" width="120" height="150">
				<li><a href="null" class="movie_cast_name">汤姆·克鲁斯</a></li>
				<li><span class="movie_cast_product" />代表作：明日边缘/碟中谍系列</span></li>
			</div>
			<div>
				<img src="image/henrycarvill.jpg" width="120" height="150">
				<li><a href="null" class="movie_cast_name">亨利·卡维尔</a></li>
				<li><span class="movie_cast_product" />代表作：正义联盟/碟中谍6</span></li>
			</div>
			<div>
				<img src="image/ving.jpg" width="120" height="150">
				<li><a href="null" class="movie_cast_name">文·拉姆斯</a></li>
				<li><span class="movie_cast_product" />代表作：低俗小说/碟中谍系列/银河护卫队</span></li>
			</div>
			<div>
				<img src="image/simon.jpg" width="120" height="150">
				<li><a href="null" class="movie_cast_name">西蒙·佩吉</a></li>
				<li><span class="movie_cast_product" />代表作：头号玩家/碟中谍系列</span></li>
			</div>
		</div>
	</div>
</body>
</html>
