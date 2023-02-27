<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(function() {
	  $(".calculate-rows").keyup(function(event) {
	    var sum = 0;
	    $(".calculate-rows").each(function() {
	      var grossTotal1 = 0;
	      $(this).find(".rows").each(function() {
	        var qty = parseFloat($(this).find(".quantity").val());
	        var rate = parseFloat($(this).find(".unit-price").val());
	        if (isNaN(quantity)) {
	        	quantity = 0;
	        }
	        if (isNaN(unit)) {
	        	unit = 0;
	        }
	        var subtotal = quantity * unit;
	        var subtotal = quantity * unit;
	        $(this).find(".total-price").val(subtotal.toFixed(2));
	        if (!isNaN(subtotal))
	        	grossTotal1 += subtotal;
	        $(".subtotal").html("&#163;" + grossTotal1.toFixed(2));
	        var gst = $('.gst').val();
	        var gst = ((grossTotal1 / 100) * gst);
	        var total = (grossTotal1 - gst).toFixed(2);
	        if (!isNaN(total))
	          $(".total-price").html("&#163;" + total);
	      });
	    });
	  });
	});

	var wrapper = $('#addrow');
	var newitem = $('.newitem');
	var removeitem = $('.removeitem');
	$(newitem).click(function(e) {
	  e.preventDefault();
	  $newrow = $('<tr class="rows"><td style="border-top: none;"><input class="form-control" type="text" name="name" required></td><td style="border-top: none;"><textarea class="form-control" rows="1" name="description"></textarea></td><td style="border-top: none;"><input class="text-center form-control quantity" type="text" value="" name="quantity"></td><td style="border-top: none;"><input class="text-center form-control unit-price" type="text" value="" name="unit_price"></td><td style="border-top: none;"><input class="form-control text-center total-price" type="text" value="0.00" readonly></td><td style="border-top: none;" class="text-center"><a class="removeitem" href="#"><i class="fa fa-times"></i></a></td></tr>');
	  $(wrapper).append($newrow);
	  $newrow.on("click", "a", function(e) {
	    e.preventDefault();
	    $(this).parent().parent().remove();
	  });
	});
	$(removeitem).click(function(e) {
	  e.preventDefault();
	  $(this).parent().parent().remove();
	});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<div class="table-responsive calculate-rows">
  <table class="table">
    <thead>
      <a href="#" class="btn newitem btn-primary tooltip-primary"><i class="fa fa-plus"></i> New Item</a>
      <tr>
        <th style="width:25%;">Item</th>
        <th style="width:41%;">Description</th>
        <th style="width:10%;" class="text-center">Quantity</th>
        <th style="width:10%;" class="text-center">Unit Price (&#163;)</th>
        <th style="width:10%;" class="text-center">Total Price (&#163;)</th>
        <th style="width:4%;"></th>
      </tr>
    </thead>
    <tbody id="addrow">
      <tr class="rows">
        <td style="border-top: none;">
          <input class="form-control" type="text" name="name" required>
        </td>
        <td style="border-top: none;">
          <textarea class="form-control" rows="1" name="description"></textarea>
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control quantity" type="text" value="" name="quantity">
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control unit-price" type="text" value="" name="unit_price">
        </td>
        <td style="border-top: none;">
          <input class="form-control text-center total-price" type="text" value="0.00" readonly>
        </td>
        <td style="border-top: none;" class="text-center"><a class="removeitem" href="#"><i class="fa fa-times"></i></a>
        </td>
      </tr>
      <tr class="rows">
        <td style="border-top: none;">
          <input class="form-control" type="text" name="name" required>
        </td>
        <td style="border-top: none;">
          <textarea class="form-control" rows="1" name="description"></textarea>
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control quantity" type="text" value="" name="quantity">
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control unit-price" type="text" value="" name="unit_price">
        </td>
        <td style="border-top: none;">
          <input class="form-control text-center total-price" type="text" value="0.00" readonly>
        </td>
        <td style="border-top: none;" class="text-center"><a class="removeitem" href="#"><i class="fa fa-times"></i></a>
        </td>
      </tr>
      <tr class="rows">
        <td style="border-top: none;">
          <input class="form-control" type="text" name="name" required>
        </td>
        <td style="border-top: none;">
          <textarea class="form-control" rows="1" name="description"></textarea>
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control quantity" type="text" value="" name="quantity">
        </td>
        <td style="border-top: none;">
          <input class="text-center form-control unit-price" type="text" value="" name="unit_price">
        </td>
        <td style="border-top: none;">
          <input class="form-control text-center total-price" type="text" value="0.00" readonly>
        </td>
        <td style="border-top: none;" class="text-center"><a class="removeitem" href="#"><i class="fa fa-times"></i></a>
        </td>
      </tr>

    </tbody>
  </table>
  <table class="table invoice-table text-right">
    <tbody class="totals">
      <tr>
        <td style="border-top: none;">Sub Total:</td>
        <td style="border-top: none;"><strong class="subtotal">&#163;0.00</strong>
        </td>
      </tr>
      <tr>
        <td style="border-top: none;">Discount:</td>
        <td style="width:20%; border-top: none;">
          <div class="fm-group input-group" style="margin-bottom:0px">
            <span class="input-group-addon">%</span>
            <input type="number" class="form-control text-right discount" value="0">
          </div>
        </td>
      </tr>
      <tr>
        <td style="border-top: none;">VAT:</td>
        <td style="border-top: none;"><strong>&#163;0</strong>
        </td>
      </tr>
      <tr>
        <td style="border-top: none;">Amount Due:</td>
        <td style="border-top: none;"><strong class="total-price">&#163;0</strong>
        </td>
      </tr>

    </tbody>
  </table>

</div>
    </body>
</html>