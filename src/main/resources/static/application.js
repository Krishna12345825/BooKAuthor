
$(document).ready(function(){
    $("#showblogPost").hide();
    getAuthors();
    function getAuthors() {

        $("#table").empty();
        $.get("http://localhost:8080/Author/list", function (data, status) {
            console.log(data);
            $("#table").append($("<thead>").append($("<th>").append("Sl_Number"))
                .append($("<th>").append("First_Name"))
                .append($("<th>").append("Last_Name"))
                .append($("<th>").append("Email"))
                .append($("<th>").append("Language"))
                .append($("<th>").append("Bio")))
            for(i=0;i<data.length;i++) {
                $("#table").append($("<tr>")
                    .append($("<td>").append(i+1))
                    .append($("<td>").append(data[i].authorFname))
                    .append($("<td>").append(data[i].authorLname))
                    .append($("<td>").append(data[i].authorEmail))
                    .append($("<td>").append(data[i].authorLanguage))
                    .append($("<td>").append(data[i].authorBio))
                    .append($("<td>").append(`
                           <i class='fas fa-eye viewDetails' style="font-size:20px;color:red"  data-aid="`+data[i].authorId+`"></i>
                           <i class="far fa-edit editAuthor" style="font-size:20px;color:red" data-bs-toggle="modal" data-bs-target="#second_form" data-aid="`+data[i].authorId+`"></i>
                           <i class="fas fa-trash deleteAuthor" style="font-size:20px;color:red" data-aid="`+data[i].authorId+`"></i>
                       `)));
            }
            loadButtons1();
        });
    }





    function getOneAuthor(id){


        $.ajax({
            url: 'http://localhost:8080/Author/' + id,
            method: 'get',
            success: function(data) {
                $("#update_authorFname").val(data.authorFname);
                $("#update_authorLname").val(data.authorLname);
                $("#update_authorEmail").val(data.authorEmail);
                $("#update_authorLanguage").val(data.authorLanguage);
                $("#update_authorBio").val(data.authorBio);
                $("#a_id").val(data.authorId);
            }
        });
    }




    $("#update").on("click", function(e) {
        let data = {
            authorFname:$("#update_authorFname").val(),
            authorLname:$("#update_authorLname").val(),
            authorEmail:$("#update_authorEmail").val(),
            authorLanguage:$("#update_authorLanguage").val(),
            authorBio:$("#update_authorBio").val()
        }
  //console.log($("#a_id").val());
        updateAuthor($("#a_id").val(),data);
    });

    function updateAuthor(id,data){
        $.ajax({
            url:'http://localhost:8080/Author/update/' + id,
            headers: {
                'Content-Type':'application/json'
            },
            type: 'PUT',
            dataType:'json',
            data:JSON.stringify(data),
            success:function (data){

                getAuthors();
                $("#authorFname").val("");
                $("#authorLname").val("");
                $("#authorEmail").val("");
                $("#authorLanguage").val("");
                $("#authorBio").val("");
            },
            error:function(){
                console.log("Error");
            }
        });
    }




    $("#add").on("click", function(e) {
        let data = {
            authorFname:$("#authorFname").val(),
            authorLname:$("#authorLname").val(),
            authorEmail:$("#authorEmail").val(),
            authorLanguage:$("#authorLanguage").val(),
            authorBio:$("#authorBio").val()
        }
        addAuthor(data);
    });

    function addAuthor(data) {
        $.ajax({
            url:"http://localhost:8080/Author/post",
            headers: {
                'Content-Type':'application/json'
            },
            type: 'POST',
            dataType:'json',
            data:JSON.stringify(data),
            success:function (data){

                getAuthors();
                $("#authorFname").val("");
                $("#authorLname").val("");
                $("#authorEmail").val("");
                $("#authorLanguage").val("");
                $("#authorBio").val("");
            },
            error:function(){
                console.log("Error");
            }
        });
    }



    function deleteAuthor(id){
        $.ajax({
            url:'http://localhost:8080/Author/delete/' + id,
            type: 'DELETE',
            dataType:'json',
            success : function(data){
                getAuthors();
            },
            error:function(){
                getAuthors();
            }
        });
    }




    function loadButtons1(){

        $(".editAuthor").click(function(e){
            getOneAuthor($($(this)[0]).data("aid"));
            e.preventDefault();
        });


        $(".deleteAuthor").click(function(e){
            deleteAuthor($($(this)[0]).data("aid"));
            e.preventDefault();
        });

        $(".viewDetails").click(function(e){
            console.log("in view");
            $(".author").hide();
            $("#showblogPost").show();
            viewBlogPosts($($(this)[0]).data("aid"));
            e.preventDefault();
        });


    }





// BlogPost



    function viewBlogPosts(aid)
    {
      //  console.log(aid);
        $("#table1").empty();

        $.get("http://localhost:8080/AuthorListBy/"+aid, function (data, status) {
            console.log(data);
            $("#table1").append($("<thead>").append($("<th>").append("No"))
                .append($("<th>").append("blogTitle"))
                .append($("<th>").append("blogDate"))
                .append($("<th>").append("blogContent")))
            for(i=0;i<data.length;i++) {
                $("#table1").append($("<tr>")
                    .append($("<td>").append(i+1))
                    .append($("<td>").append(data[i].blogTitle))
                    .append($("<td>").append(data[i].blogDate))
                    .append($("<td>").append(data[i].blogContent))
                    .append($("<td>").append(`
                           <i class="far fa-edit editBlogPost" style="font-size:20px;color:red" data-bs-toggle="modal" data-bs-target="#second_form1" data-bid="`+data[i].blogId+`"></i>
                           <i class="fas fa-trash deleteBlogPost" style="font-size:20px;color:red" data-bid="`+data[i].blogId+`"></i>
                       `)));
            }
            loadButtons2();
        });


        $("#add1").on("click", function(e) {
            console.log("blogpost inside");
            let data = {
                blogTitle:$("#blogTitle").val(),
                blogDate:$("#blogDate").val(),
                blogContent:$("#blogContent").val()
            }
            addBlogPost(data,aid);
        });

        function addBlogPost(data,aid) {
            $.ajax({
                url:"http://localhost:8080/BlogPostByAdd?blogTitle="+data.blogTitle+"&blogDate="+data.blogDate+"&blogContent="+data.blogContent+"&authorId="+aid,
                type: 'POST',
                success:function (data){
                    //console.log(data);
                    viewBlogPosts(aid);
                    $("#blogTitle").val("");
                     $("#blogDate").val("");
                    $("#blogContent").val("");
                },
                error:function(){
                    console.log("Error");
                }
            });
        }








        function loadButtons2(){


            $(".editBlogPost").click(function(e){
                getOneBlogPost($($(this)[0]).data("bid"));
                e.preventDefault();
            });

            $(".deleteBlogPost").click(function(e){
                deleteBlogPost($($(this)[0]).data("bid"));
                e.preventDefault();
            });

        }




        function getOneBlogPost(bid){
             console.log(bid);
            $.ajax({

                url: 'http://localhost:8080/BlogPostById/' + bid,
                method: 'get',
                success: function(data) {
                    $("#update_blogTitle").val(data.blogTitle);
                    $("#update_blogDate").val(data.blogDate);

                    $("#update_blogContent").val(data.blogContent);
                    $("#b_id").val(data.blogId);
                    $("#updateBlogPost").show();
                }
            });
        }



        $("#update1").on("click", function(e) {
            let data = {
                blogTitle:$("#update_blogTitle").val(),
                blogDate:$("#update_blogDate").val(),
                blogContent:$("#update_blogContent").val()
            }
            console.log(data);
            updateBlogPost($("#b_id").val(),data,aid);

        });

        function updateBlogPost(bid,data,aid){

            $.ajax({
                url:"http://localhost:8080/BlogPost/Update?blogTitle="+data.blogTitle+"&blogDate="+data.blogDate+"&blogContent="+data.blogContent+"&blogId="+bid+"&authorId="+aid,
                type: 'POST',
                success:function (data){
                    //console.log(data);
                    viewBlogPosts(aid);
                    $("#update_blogTitle").val("");
                    $("#blogDate").val("");
                    $("#update_blogContent").val("");
                    $("#table1").empty();
                },
                error:function(){
                    console.log("Error");
                }
            });
        }




        function deleteBlogPost(bid){
            $.ajax({
                url:'http://localhost:8080/BlogPost/delete/' + bid,
                type: 'DELETE',
                dataType:'json',
                success : function(data){
                    viewBlogPosts(aid);
                },
                error:function(){
                    viewBlogPosts(aid);
                }
            });
        }












    }

    $("#viewMaster").on("click",function (){
        getAuthors();
        $(".author").show();
        $("#showblogPost").hide();
    })


});


