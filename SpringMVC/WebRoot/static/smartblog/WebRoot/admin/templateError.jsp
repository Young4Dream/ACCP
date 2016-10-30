 <s:if test="hasFieldErrors()">
        	<div class="error" id="errorMessage">
        		<s:iterator value="fieldErrors">
        			<s:iterator value="value"><s:property escape="false"/><br/></s:iterator>
        		</s:iterator>
        		
        	</div>
        </s:if>
        <s:if test="hasActionErrors()">
        	<div class="error" id="errorMessage">
        		<s:iterator value="actionErrors">
        			<s:property escape="false"/><br/>
        		</s:iterator>
        	</div>
</s:if>