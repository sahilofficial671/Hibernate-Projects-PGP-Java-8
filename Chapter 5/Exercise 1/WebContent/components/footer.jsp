<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$("[name=bookId]").on("change", function(){
			
			$.ajax({
				url: './book/get',
				method: 'get',
				data: {bookId: $(this).val()},
				success: function(data){
					var book = JSON.parse(data);
					console.log(JSON.parse(data));
					var book_details = $('#book_details');
					book_details.removeClass('d-none')
					book_details.find('#name').text(book.name);
					book_details.find('#category').text(book.category);
					book_details.find('#edition').text(book.edition);
					book_details.find('#price').text(book.price);
					book_details.find('#quantity').text(book.quantity);
					book_details.find('#author_name').text(book.author.name);
					book_details.find('#publisher').text(book.publisher);
					book_details.find('#publishingYear').text(book.publishingYear);
				},
			});
		});
	});
</script>
<%
	request.getSession().setAttribute("status", null);
	request.getSession().setAttribute("message", null);
%>