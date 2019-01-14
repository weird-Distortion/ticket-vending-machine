<%@ include file="common/header.jspf" %>

<div class="container">
  <div style="text-align: center">TVM</div>
  <div class="row">
    <div class="col-sm-4">
      left part
      <div>${ticketType}</div>
      <a href="/index">Cancel</a>
    </div>
    <div class="col-sm-2">
      right part
      <div>
        Left to insert:
        ${moneyLeft}
      </div>
      <div>
        <c:forEach items="${userInputList}" var="userCoinValue">
          ${userCoinValue}
        </c:forEach>
      </div>
      <form:form method="post" modelAttribute="userCoin">
        <div><form:input type="number" path="coinValue" step="0.1" min="0"/></div>
        <form:input type="submit" path="coinValue" value="Insert"/>
      </form:form>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>