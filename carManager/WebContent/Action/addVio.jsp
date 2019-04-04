<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Now UI Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="../Main/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../Main/assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../Main/assets/demo/demo.css" rel="stylesheet" />
    
	<script src="./layui/layui.js" charset="utf-8"></script>
	<link rel="stylesheet" href="layui/css/layui.css"  media="all">
	
	
	<script type="text/javascript">
	layui.use(['form', 'layedit', 'laydate'], function(){
		  var form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  
		  //日期
		  laydate.render({
		    elem: '#date'
		  });
		  laydate.render({
		    elem: '#date1'
		  });
		  laydate.render({
		    elem: '#date2'
		  });  
		});

	</script>
	
</head>
<body>
<div class="content" style="margin-left:18%">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="title">违章记录添加</h5>
                            </div>
                            <div class="card-body">
                                <form action="/carManager/addViolation" method="get">
                                    <div class="row">
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>身份证号</label>
                                                <input type="text" required="required" class="form-control"  placeholder="身份证号" value="" name="idNumber">
                                            </div>
                                        </div>
                                        <div class="col-md-3 px-1">
                                            <div class="form-group">
                                                <label>罚款金额</label>
                                                <input type="text" required="required" class="form-control" placeholder="罚款金额" value="" name="Penalty">
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>车牌号</label>
                                                <input type="text" required="required" class="form-control" placeholder="车牌号" value="" name="carNumber">
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-1">
                                            <div class="form-group">
                                                <label>扣除分数</label>
                                                <input type="text" required="required" class="form-control" placeholder="扣除分数" value="" name="vioScore">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>违章日期</label>
                                                <input type="text" required="required" class="form-control" placeholder="违章日期" value="" name="vioTime" id="date2" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>处理状态</label>
                                                <select required="required" class="form-control" placeholder="处理状态" name="vioStatus">
  													<option value ="已处理">已处理</option>
  													<option value ="未处理">未处理</option>
												</select>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>违章内容</label>
                                                <textarea required="required" rows="4" cols="80" class="form-control" placeholder="违章内容" value="" name="vioContent"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" onclick="return confirm('确定添加该条违章记录?')" class="btn btn-primary btn-block" value="添加" >
	                                                   
                                </form>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
</body>
</html>