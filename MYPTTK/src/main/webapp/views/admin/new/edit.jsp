<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%--API muốn gọi về--%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
<%--    <script src="<c:url value='/ckeditor-libs/ckeditor.js' />"></script>--%>
<%--    <script src="/ckeditor-libs/adapters/jquery.js"></script>--%>
<%--    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>--%>
<%--    <script src="ckeditor-libs/ckeditor.js"></script>--%>
<%--    <script src="ckeditor-libs/adapters/jquery.js"></script>--%>
<%--    <script src="<c:url value='/ckeditor-libs/ckeditor.js/' />"></script>--%>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
                    chủ</a></li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">${messageResponse}</div>
                    </c:if>

                    <!-- QUAN TRỌNG: Submit dữ liệu -->
                    <form id="formSubmit">
                        <br></br>
                        <br> </br>

                        <div class="form-group">
                            <%--Thể loại--%>
                            <label class="col-sm-3 control-label no-padding-right">Thể loại
                            </label>
                            <%--Selectbox thể loại--%>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryCode"
                                        name="categoryCode">
                                    <%--PROCESSING VIEW FOR ADD AND EDIT--%>
                                    <!-- thêm mới -->
                                    <%--                                        Thể loại tag--%>
                                    <c:if test="${empty model.categoryCode}">
                                        <option value="">Chọn loại bài viết</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.code}">${item.name}</option>
                                        </c:forEach>
                                    </c:if>

                                    <!-- chỉnh sửa -->
                                    <c:if test="${not empty model.categoryCode}">
                                        <option value="">Chọn loại bài viết</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.code}"
                                                    <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                    ${item.name}
                                            </option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>

                        <br/> <br/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu
                                đề</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="title" name="title"
                                       value="${model.title}"/>
                            </div>
                        </div>
                        <br/> <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình
                                đại diện</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="thumbnail"
                                       name="thumbnail" value="${model.thumbnail}"/>
                            </div>
                        </div>
                        <br/> <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô
                                tả ngắn</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="shortDescription"
                                       name="shortDescription" value="${model.shortDescription}"/>
                            </div>
                        </div>
                        <br/> <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội
                                dung</label>
                            <div class="col-sm-9">
									<textarea rows="" cols="" id="content" name="content" style="width: 820px; height: 175px">${model.content}</textarea>
                            </div>
                        </div>


                        <br/> <br/>


                        <%--Processing button update or add new--%>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <!-- Button cập nhật bài viết & thêm bài viết - Đẫy data lên server -->
                                <%--model được settAttribute trên controller. Có 2 trường hợp khởi tạo ra model
                                -1- model có đầy đủ các param
                                -2- mdel chỉ có param type và id--%>
                                <%--Trong trường hợp 2 có 2 trường hợp nhỏ hơn. URL có param là type hoặc type và id--%>
                                <%--  Khi click vào button chỉnh sửa bài viết tại Client. url được trả về có type=eidt và id=id (đã có value từ khi list new khởi tạo).
                              url này được gửi lên control xác định. Tại controller, các param được mapping vào model (model này đã mapping dữ liệu type = edit, id = id).
                              model này được settAttribuite cùng với list Catetogry. Controller dispatcher trang edit.jsp.--%>

                                <c:if test="${not empty model.id}">
                                    <input type="button"
                                           class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button"
                                           class="btn btn-white btn-warning btn-bold"
                                           value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>

                            </div>
                        </div>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	var editor = '';
    $( document ).ready( function() {
        editor = CKEDITOR.replace('content');
    } );

    $('#btnAddOrUpdateNew').click(function (e) {
        // tránh submit nhầm URL
        e.preventDefault();
        // var tittle = $('title').val()
        // var categoryCode = $('categ  oryCode').val();
        // var thumbnail = $('thumbnail').val();
        // var content = $('content').val();
        // var shortDescription = $('shortDescription').val();
        /*Dùng khái niệm serializeArray() trong JS: get mảng lấy tất cả giá trị (name) trong cái form
        --->*/
        var formData = $('#formSubmit').serializeArray();
        var data = {};
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        data["content"] = editor.getData();
        var id = $('#id').val();
        if (id === "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });

    // dùng ajax call API
    function addNew(data) {
        $.ajax({
            // chỉ định URLl, cái API muốn gọi về
            url: '${APIurl}',
            // định nghĩa type do là thêm mới -> type = POST
            type: 'POST',
            // kiểu DL client gửi lên server (Cái mà server nhận được)
            contentType: 'application/json',
            data: JSON.stringify(data),
            // kiểu DL server gửi lên client (Cái mà client nhận được)
            dataType: 'json',
            success: function (result) { // result = newmodel
                // result là data trả về từ server (json);
            	window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            // định nghĩa type do là thêm mới -> type = POST
            type: 'PUT',
            // kiểu DL client gửi lên server (Cái mà server nhận được)
            contentType: 'application/json',
            data: JSON.stringify(data),
            // kiểu DL server gửi lên client (Cái mà client nhận được)
            dataType: 'json',
            success: function (result) {
                // result là data trả về từ server (json);
            	window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }


    /* var editor = '';
    $(document).ready(function() {
        editor = CKEDITOR.replace('content');
    });

    $('#btnAddOrUpdateNew').click(function(e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function(i, v) {
            data["" + v.name + ""] = v.value;
        });
        data["content"] = editor.getData();
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });
    function addNew(data) {
        $
                .ajax({
                    url : '${APIurl}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${NewURL}?type=edit&id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
						}
					});
		}
		function updateNew(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${NewURL}?type=edit&id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
						}
					});
		} */
</script>
</body>
</html>